class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        	int n = s.length();
		int[] first = new int[26];
		int[] last = new int[26];
		Arrays.fill(first, n);
		for (int i = 0; i < n; i++) {
			int c = s.charAt(i) - 'a';
			first[c] = Math.min(first[c], i);
			last[c] = Math.max(last[c], i);
		}
		List<int[]> intervals = new ArrayList<>();
		for (int c = 0; c < 26; c++) {
			if (first[c] == n) {
				continue;
			}
			int start = first[c];
			int end = last[c];
			boolean valid = true;
			for (int i = start; i <= end; i++) {
				int x = s.charAt(i) - 'a';
				if (first[x] < start) {
					valid = false;
					break;
				}
				end = Math.max(end, last[x]);
			}
			if (valid) {
				intervals.add(new int[] { start, end });
			}
		}
		intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
		List<String> ans = new ArrayList<>();
		int prevEnd = -1;
		for (int[] interval : intervals) {

			int left = interval[0];
			int right = interval[1];
			if (left > prevEnd) {
				ans.add(s.substring(left, right + 1));
				prevEnd = right;
			}
		}
		return ans;
    }
}   
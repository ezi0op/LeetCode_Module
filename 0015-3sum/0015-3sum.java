class Solution {
    public List<List<Integer>> threeSum(int[] b) {
   // take an arrayList
		List<List<Integer>> a = new ArrayList<>();

		Arrays.sort(b);

		for (int i = 0; i < b.length - 2; i++) {
			// check for duplicate element at index i and skip the index if it is duplicate
			if (i > 0 && b[i] == b[i - 1]) {
				continue;
			}
			int s = i + 1;
			int e = b.length - 1;
			while (s < e) {
				int sum = b[i] + b[s] + b[e];
				if (sum == 0) {
					a.add(Arrays.asList(b[i], b[s], b[e]));
					while (s < e && b[s] == b[s + 1]) {
						s++;
					}
					while (s < e && b[e] == b[e - 1]) {
						e--;
					}
					s++;
					e--;
				} else if (sum < 0) {
					s++;
				} else {
					e--;
				}
			}
		}
		return a;

    }
}
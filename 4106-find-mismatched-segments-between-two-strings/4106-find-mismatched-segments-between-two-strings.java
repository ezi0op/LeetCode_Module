class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> res = new ArrayList<>();
		int i = 0;
		int n = Math.min(s1.length(), s2.length());
		while (i < n) {
			// skipping the characters that are same in both strings
			if (s1.charAt(i) == s2.charAt(i)) {
				i++;
				continue;
			}
			// assigning the start index of the mismatched segment
			int start = i;

			// continuing to move the index forward until we find a character that is
			// different in both strings
			while (i < n && s1.charAt(i) != s2.charAt(i)) {
				i++;
			}
			// get sub from start to i and add to the result list
			String first = s1.substring(start, i);
			String second = s2.substring(start, i);
			List<String> segment = new ArrayList<>();
			segment.add(first);
			segment.add(second);
			res.add(segment);

		}
		return res;
    }
}
class Solution {
    public int countVowelSubstrings(String word) {
        int ans = 0, n = word.length();
		for (int i = 0; i < n; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = i; j < n; j++) {
				char c = word.charAt(j);
				// if the current character is not a vowel, we break out of the inner loop as we
				// cannot form a valid substring anymore
				if ("aeiou".indexOf(c) == -1) {
					break;
				}
				set.add(c);
				// if the size of the set is 5, it means we have found a substring that contains
				if (set.size() == 5) {
					ans++;
				}
			}
		}
		return ans;
    }
}
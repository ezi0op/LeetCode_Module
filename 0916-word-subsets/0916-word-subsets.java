class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
       List<String> ans = new ArrayList<>();

		int[] maxFreq = new int[26];
		// get the max frequency of each letter in words2
		for (String word : words2) {
			int[] freq = new int[26];
			for (char ch : word.toCharArray()) {
				freq[ch - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				maxFreq[i] = Math.max(maxFreq[i], freq[i]);

			}
		}
		for (String word : words1) {
			// count freq of each letter in the current word
			int[] freq = new int[26];
			for (char ch : word.toCharArray()) {
				freq[ch - 'a']++;
			}
			boolean isSubset = true;
			// check if the current word contains all the letters of each word in words2
			// with the required frequency
			for (int i = 0; i < 26; i++) {
				if (freq[i] < maxFreq[i]) {
					isSubset = false;
					break;
				}

			}
			// if the current word is universal, add it to the answer list
			if (isSubset) {
				ans.add(word);
			}
		}
		return ans; 
    }
}
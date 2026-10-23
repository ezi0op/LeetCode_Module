class Solution {
    public int prefixCount(String[] words, String pref) {
        	int count = 0;
		// iterate through the array of words and check if each word starts with the
		// given prefix
		for (String word : words) {
			if (word.startsWith(pref)) {
				count++;
			}
		}
		return count;
    }
}
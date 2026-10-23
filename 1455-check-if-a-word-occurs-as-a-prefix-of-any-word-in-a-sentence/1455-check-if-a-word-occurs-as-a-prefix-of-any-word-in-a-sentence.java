class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        	String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			// check if string at index i starts with the given searchWord then return the
			// index + 1 else return -1
			if (words[i].startsWith(searchWord)) {
				return i + 1;
			}
		}
		return -1;
    }
}
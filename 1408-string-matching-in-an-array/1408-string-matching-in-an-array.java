class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {

				// first check if index are not equal and then check if the word at index j
				// contains the word at index i as a substring
				if (i != j && words[j].contains(words[i])) {
					ans.add(words[i]);
					break;
				}
			}
		}
		return ans;
    }
}
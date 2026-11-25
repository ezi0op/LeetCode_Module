class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charFreq = new HashMap<>();
		Map<String, Character> strFreq = new HashMap<>();
		String[] words = s.trim().split(" ");
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			String word = words[i];
			// if pattenr char length is not equal to words length then we will return false
			if (pattern.length() != words.length) {
				return false;
			}
			if (charFreq.containsKey(c) && !charFreq.get(c).equals(word)) {
				return false;
			}
			if (strFreq.containsKey(word) && strFreq.get(word) != c) {
				return false;
			}
			charFreq.put(c, word);
			strFreq.put(word, c);
		}
		return true;
    }

}
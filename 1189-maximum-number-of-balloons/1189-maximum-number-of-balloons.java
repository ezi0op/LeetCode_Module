class Solution {
    public int maxNumberOfBalloons(String text) {
        	int min = Integer.MAX_VALUE;
		HashMap<Character, Integer> map = new HashMap<>();

		char[] balloon = { 'b', 'a', 'l', 'o', 'n' };

		// count frequency of each character in the text and store it in the map
		for (int i = 0; i < text.length(); i++) {
			map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
		}

		for (char ch : balloon) {
			if (!map.containsKey(ch)) {
				return 0;
			}

			// get the frequency of the character from the map and divide it by 2 if it is
			// 'l' or 'o' since they are counted twice in the word "balloon"
			int freq = map.get(ch);
			// if the character is 'l' or 'o', divide the frequency by 2 since they are
			// counted twice in the word "balloon"
			if (ch == 'l' || ch == 'o') {
				freq /= 2;
			}
			min = Math.min(min, freq);
		}
		return min;
    }
}
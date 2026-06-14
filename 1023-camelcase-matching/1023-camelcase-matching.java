class Solution {
   public  List<Boolean> camelMatch(String[] queries, String pattern) {
		// take an array list to store the boolean value of matching or not
		List<Boolean> ans = new ArrayList<>();

		// loop through each string in queries array
		for (String word : queries) {
			// take two index i and j to traverse the word and pattern
			// i for word and j for pattern
			int i = 0;
			int j = 0;
			// loop until i is less than length of word
			while (i < word.length()) {
				// if j is less than length of pattern and char at i word is equal
//				to char at j pattern
				// then move to next char of word and pattern
				if (j < pattern.length() && word.charAt(i) == pattern.charAt(j)) {
					i++;
					j++;
					// if character at i word is upper case then increse i check for next char of
					// word
				} else if (Character.isLowerCase(word.charAt(i))) {
					i++;
				} else {
					break;
				}
			}
			// if i is equal to length of word and j is equal to length of pattern then add
			// true to ans otherwise false
			ans.add(i == word.length() && j == pattern.length());
		}
		return ans;
	}
}
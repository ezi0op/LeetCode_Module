class Solution {
    public int maxSubstrings(String word) {
       	int count = 0, n = word.length();
		Map<Character, Integer> pos = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = word.charAt(i);
			// if charcter is not present then we will add with index
			if (!pos.containsKey(c)) {
				pos.put(c, i);
				// if index of charcter is greater than or equal to 4 then we will increment
				// count and clear the map
			} else if (i - pos.get(c) + 1 >= 4) {
				count++;
				pos.clear();
			}
		}
		return count; 
    }
}
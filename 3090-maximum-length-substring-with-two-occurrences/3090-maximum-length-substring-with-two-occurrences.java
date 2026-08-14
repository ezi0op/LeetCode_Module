class Solution {
    public int maximumLengthSubstring(String s) {
Map<Character, Integer> map = new HashMap<>();
		int left = 0;
		int max = 0;
		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			// add character to map
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			// if the size of map is greater than 2 then we will remove the character from
			// map
			while (map.get(ch) > 2) {

				char leftChar = s.charAt(left);
				// decrement the frequency of the character at index left and increment the left
				// pointer until the size of map is less than or equal to 2
				map.put(leftChar, map.get(leftChar) - 1);
				left++;
			}
			// update the max length of substring with at most 2 distinct characters
			max = Math.max(max, right - left + 1);
		}
		return max;

    }
}
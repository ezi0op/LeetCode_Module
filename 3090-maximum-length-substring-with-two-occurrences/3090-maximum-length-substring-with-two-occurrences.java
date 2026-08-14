class Solution {
    public int maximumLengthSubstring(String s) {
// take an array of size 26 to store the frequency of each character in the
		// given string
		int[] freq = new int[26];

		// take left and right for traversing the string and max to store the maximum
		// length of substring
		int left = 0;
		int max = 0;

		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			// increment the frequency of the character at index right
			freq[ch - 'a']++;
			// if the frequency of the character at index right is greater than 2 then we
			// will decrement the frequency of the character at index left and increment the
			// left pointer until the frequency of the character at index right is less than
			// or equal to 2
			while (freq[ch - 'a'] > 2) {
				// decrement the frequency of the character at index left and increment the left
				char leftChar = s.charAt(left);
				freq[leftChar - 'a']--;
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;

    }
}
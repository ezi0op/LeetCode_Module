class Solution {
    public int lengthOfLongestSubstring(String s) {
        	// first we are l as left pointer and max as max length of substring without
		// repeating characters
		int l = 0;
		int max = 0;

		// first to itearete throw whole string
		for (int right = 0; right < s.length(); right++) {
			// we will update second loop with left pointer to check for the repeating
			// characters in the substring
			for (int i = l; i < right; i++) {
				// if char at i is equal to char at r then we will update the left pointer to
				// i+1 and break the loop
				if (s.charAt(i) == s.charAt(right)) {
					l = i + 1;
					break;
				}

			}
			// then we will update the max length of substring without repeating characters
			// by using Math.max method to get the max length of substring without repeating
			// characters
			max = Math.max(max, right - l + 1);
		}
		return max;
        
    }
}
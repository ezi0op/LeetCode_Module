class Solution {
    public int longestPalindrome(String a) {
        
		int[] freq = new int[128];
		for (char c : a.toCharArray()) {
			freq[c]++;
		}
		int ans = 0;
		boolean odd = false;

		for (int f : freq) {
			if (f % 2 == 0) {
				ans += f;
			} else {
				ans += f - 1;
				odd = true;
			}
		}
		if (odd) {
			ans++;
		}
		return ans;

    }       
}
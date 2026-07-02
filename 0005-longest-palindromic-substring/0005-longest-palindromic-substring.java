class Solution {
   public  boolean isPalindrome(String s, int l, int r) {
		if (l >= r) {
			return true;
		}
		if (s.charAt(l) != s.charAt(r)) {
			return false;
		}
		return isPalindrome(s, l + 1, r - 1);
	}

	 String longestPalindrome(String s) {
		int n = s.length();
		int start = 0;
		int maxLen = 1;

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (isPalindrome(s, i, j)) {
					if (j - i + 1 > maxLen) {
						start = i;
						maxLen = j - i + 1;
					}
				}
			}

		}
		return s.substring(start, start + maxLen);

	}
}
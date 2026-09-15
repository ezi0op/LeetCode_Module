class Solution {
    public static int maxPalindromes(String s, int k) {
		int start = 0;
		int count = 0;
		for (int right = 0; right < s.length(); right++) {

			for (int left = right; left >= start; left--) {
				if (right - left + 1 >= k && isPalindromeMax(s, left, right)) {

					count++;
					start = right + 1;

					break;
				}
			}

		}
		return count;



	}

	private static boolean isPalindromeMax(String s, int left, int i) {
		while (left < i) {
			if (s.charAt(left) != s.charAt(i)) {
				return false;
			}
			left++;
			i--;
		}
		return true;
	}

}
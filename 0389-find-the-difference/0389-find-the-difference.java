class Solution {
    public char findTheDifference(String s, String t) {
        	char ans = 0;
		for (char ch : s.toCharArray()) {
			ans ^= ch;
		}
		char ans2 = 0;
		if (t.length() > s.length()) {
			for (char ch : t.toCharArray()) {
				ans2 ^= ch;
			}
		}
		if (ans2 != 0) {
			return (char) (ans ^ ans2);
		}

		return (char) (ans ^ ans2);
    }
}
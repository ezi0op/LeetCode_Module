class Solution {
    public int calculateScore(int a, int b) {
        	int s1 = 0, s2 = 0;
		while (a>0||b>0) {
			if (a > 0) {
				a = a & (a - 1);
				s1++;

			}
			if (b > 0) {
				b = b & (b - 1);
				s2++;

			}
		
		}
		return (s1 >= s2) ? s1 * s2 : s2 / s1;
    }
}
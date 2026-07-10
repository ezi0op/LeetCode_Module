class Solution {
    public boolean judgeSquareSum(int c) {
        long s = 0;
		long e = (int) Math.sqrt(c);
		while (s <= e) {
			long sum = s * s + e * e;
			if (sum == c) {
				return true;
			}

			if (sum > c) {
				e--;
			} else {
				s++;
			}
		}
		return false;
    }
}
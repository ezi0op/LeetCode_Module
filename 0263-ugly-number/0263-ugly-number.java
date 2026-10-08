class Solution {
    public boolean isUgly(int n) {
        	if (n <= 0) {
			return false;
		}
		// here we are dividing the given number n by 2, 3 and 5 until it is not
		// divisible by any of them
		while (n % 2 == 0) {
			n /= 2;
		}
		while (n % 3 == 0) {
			n /= 3;
		}
		while (n % 5 == 0) {
			n /= 5;
		}
		// if it is equal to 1 then it is an ugly number else it is not
		return n == 1;

    }
}
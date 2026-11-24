class Solution {
    public int maxLength(int[] nums) {
		int n = nums.length;
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			long prod = 1;
			long currGcd = 0;
			long currLcm = 1;
			for (int j = i; j < n; j++) {
				// first do the prod of each ele
				prod *= nums[j];
				// get current gcd and lcm of the subarray
				currGcd = gcd(currGcd, nums[j]);
				currLcm = lcm(currLcm, nums[j]);
				// if prod and gcd*lcm are equal then we will update maxLen
				if (prod == currGcd * currLcm) {
//					by using j-i+1 we are calculating the length of the subarray from index i to j
					maxLen = Math.max(maxLen, j - i + 1);
				}
			}
		}
		return maxLen;

	}

	// here we getting gcd of two numbers
	private static long gcd(long a, long b) {
		// by using euclidean algorithm we can find gcd of two numbers
		// means divide a by b and get the remainder and then replace a with b and b
		// with the remainder and repeat this process until b becomes 0. The value of a
		// at that point will be the gcd of the two numbers.
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	// here we are calculating lcm of two numbers by using the formula lcm(a,b) =
	// (a*b)/gcd(a,b)
	private static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}
}
class Solution {
    public int maxSum(List<Integer> nums, int k) {
      	int[] count = new int[30];
		long ans = 0, mod = 1000000007;
		// count 1 bits at each position
		for (int x : nums) {
			for (int i = 0; i < 30; i++) {
				// first we do left shift 1 by i to get the bit at position i and then we do
				// bitwise AND with x to check if the bit is set or not
				if ((x & (1 << i)) != 0) {
					count[i]++;
				}
			}
		}

		while (k-- > 0) {
			long x = 0;
			// here we are checking for each bit position from 31 to 0 and if the count of
			// that bit is greater than 0 then we are setting that bit in x and decrementing
			// the count of that bit
			for (int i=0; i < 30; i++) {
				if (count[i] > 0) {
					// here we are left shifting 1 by i to get the bit at position i and then we do
					// bitwise OR with x to set that bit in x
					x |= (1L << i);
					count[i]--;
				}
				
			}
            // doing mod to avoid overflow of ans because x*x can be very large
			ans = (ans + x * x) % mod;
		}
		return (int) ans;

  
    }
}
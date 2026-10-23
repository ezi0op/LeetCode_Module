class Solution {
    public int sortPermutation(int[] nums) {
        	int k = -1;
		for (int i = 0; i < nums.length; i++) {
			// check if index and number are not equal then we will keep doing bitwise AND
			// operation of k and nums[i] until we fin	d the first element which is not in
			// its correct position
			if (nums[i] != i) {
				// keep doing bitwise AND operation of k and nums[i] until we find the first
				// element which is not in its correct position
				k &= nums[i];
				// if k is 0 then we will return 0 else we will return k
				if (k == 0) {
					return 0;
				}
			}
		}
		// if k is negative then we will return 0 else we will return k
		return Math.max(k, 0);
    }
}
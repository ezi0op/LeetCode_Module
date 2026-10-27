class Solution {
    public int maxProduct(int[] nums) {
        
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				// check if i and j are not equal then we will calculate the product of nums[i]
				// - 1 and nums[j] - 1 and update the max variable if the product is greater
				// than the current max value
				int prod = (nums[i] - 1) * (nums[j] - 1);
				max = Math.max(max, prod);
			}
		}
		return max;
    }
}
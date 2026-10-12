class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
		int ans = 1;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			// first get rem of each num by mod of k
			int rem = nums[i] % k;
			for (int j = i; j < n; j++) {
				// if rem of the current num is not equal to rem then we will break the loop
				if (nums[j] % k != rem) {
					break;
				}
				
				sum += nums[j];
				//if sum is div by k we get do j - i +1  we get max length of sub array
				if (sum % k == rem) {
					ans = Math.max(ans, j - i + 1);
				}
			}
		}
		return ans;
    }
}
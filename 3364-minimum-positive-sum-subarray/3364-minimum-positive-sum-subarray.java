class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
       int count = Integer.MAX_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			int sum = 0;
			// start from i and go till end of list and check subarray length is between l
			// and r
			for (int j = i; j < nums.size() && j - i + 1 <= r; j++) {
				sum += nums.get(j);
				int len = j - i + 1;
				// if length is between l and r and sum is greater than 0 then we will update
				// the count to the minimum of count and sum
				if (len >= l && sum > 0) {
					count = Math.min(count, sum);
				}

			}
		}
		return count == Integer.MAX_VALUE ? -1 : count;
    }
}
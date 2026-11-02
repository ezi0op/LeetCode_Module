class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
       int moves = 0;
		Arrays.sort(nums);
		int target = nums[n / 2];
		for (int i = 0; i < n; i++) {
			moves += Math.abs(nums[i] - target);

		}

		return moves;

    }
}
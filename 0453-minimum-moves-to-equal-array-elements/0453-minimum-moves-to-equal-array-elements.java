class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
		// find the maximum element in the array nums
		for (int num : nums) {
			min = Math.min(min, num);
		}
		int moves = 0;
		// calculate the total number of moves required to make all elements equal to
		// the maximum element by subtracting each element from the maximum and adding
		// the result to the moves variable
		for (int num : nums) {
			moves += num - min;
		}
		return moves;
    }
}
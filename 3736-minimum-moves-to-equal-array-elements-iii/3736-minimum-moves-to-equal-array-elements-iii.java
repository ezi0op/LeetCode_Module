class Solution {
    public int minMoves(int[] nums) {
        int ans = 0, max = Integer.MIN_VALUE;
		for (int num : nums) {
			max = Math.max(	max, num);
		}
		int moves = 0;
		//by removing min from n each number we will get number of moves req
		for (int n : nums) {
			moves += max- n;
		}	//get  min number in the array nums
		
		return  moves;
    }
}
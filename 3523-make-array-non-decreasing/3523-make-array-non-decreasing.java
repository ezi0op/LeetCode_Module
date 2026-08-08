class Solution {
    public int maximumPossibleSize(int[] nums) {
        		int count = 0;
		int prev = Integer.MIN_VALUE;
		for (int a : nums) {
			if (a >= prev) {
				count++;
				prev = a;
			}
		}
		return count;
    }
}
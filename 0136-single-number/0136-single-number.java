class Solution {
    public int singleNumber(int[] nums) {
 int c = 0;
		int i = 0;
		
		while (i < nums.length) {
			c^= nums[i];
			i++;
			
		}
		return c;
    }
}
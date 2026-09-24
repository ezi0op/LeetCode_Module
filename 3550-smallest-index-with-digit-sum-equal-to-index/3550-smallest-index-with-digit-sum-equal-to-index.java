class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
		
		for (int i = 0; i < n; i++) {
            int sum = 0;
			int dig= nums[i];
			while(dig>0) {
				sum += dig%10;
				dig/=10;
			}
			if(sum==i) {
				return i;
			}

		}
		return -1;
    }
}
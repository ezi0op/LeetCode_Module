class Solution {
    public long maxDifference(int[] nums) {

        int n = nums.length;
        long d1 = 0;
        long d2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            //take one score
            long one;
            if (nums[i] % 3 == 0) {
                one = nums[i] - d1;
            } else {
                one = nums[i] + d1;
            }
            //take two score
            long two=Long.MIN_VALUE;
            if (i + 1 < n) {
                //get sum
                long sum = (long) nums[i] + nums[i + 1];
                if (sum % 3 == 0) {
                    two = sum - d2;
                } else {
                    two = sum + d2;
                }

                

            }
            long cur = Math.max(one, two);
                d2 = d1;
                d1 = cur;
        
        }
            return d1;
    }
}
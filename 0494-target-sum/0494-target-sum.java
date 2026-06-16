class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,0,0,target);
    }
    static int solve(int[] nums,int index,int sum,int target){
        if(index==nums.length){
            return sum==target?1:0;
        }
        int abs=solve(nums,index+1,sum+nums[index],target);
        int sub=solve(nums,index+1,sum-nums[index],target);
        return abs+sub;
    }
}
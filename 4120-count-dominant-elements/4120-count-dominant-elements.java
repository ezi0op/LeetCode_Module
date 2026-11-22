class Solution {
    public int countDominantElements(int[] nums) {
        int dom=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i==0&&n==1){
                dom++;
            }else if(i==0){
                if(nums[i]>=nums[i+1]){
                    dom++;
                }
            }else if(i==n-1){
                if(nums[i]>=nums[i-1]){
                    dom++;
                }
            }else{
                if(2l*nums[i]>=(long)nums[i-1]+nums[i+1]){
                    dom++;
                }
            }

         

            
        }
        return dom;
        
    }
}
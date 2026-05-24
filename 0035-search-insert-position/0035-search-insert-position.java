class Solution {
    public int searchInsert(int[] n, int target) {
        int s=0;
        int e=n.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(target<=n[mid]){
                e=mid-1;
            }else if(target>=n[mid]){
                s=mid+1;
            }else{
                return mid;
            }
        }
        return s;
    }
}
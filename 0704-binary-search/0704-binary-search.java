class Solution {
    public int search(int[] a, int target) {
        int s=0;
        int e=a.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target<a[m]){
                e=m-1;
            }else if(target>a[m]){
                s=m+1;
            }else{
                return m;
            }
        }
        return -1;
    }
}
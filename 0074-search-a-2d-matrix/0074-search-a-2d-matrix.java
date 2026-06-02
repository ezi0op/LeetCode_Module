class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        int r=0;
        int c=a[0].length-1;
        while(r<a.length&&c>=0){
            int m=r+(c-r)/2;
            if(a[r][c]==target){
                return true;
            }else if(a[r][c]<target){
                r++;
            }else{
                c--;
            }
        }
        return false;
        
    }
}
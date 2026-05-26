class Solution {
    public int findPeakElement(int[] a) {
        int s=0;
        int e=a.length-1;
        while(s<e){
            int  m=s+(e-s)/2;
            if(a[m]>a[m+1]){
                e=m;
            }else{
                s=m+1;
            }
        }
        return s;
    }
}
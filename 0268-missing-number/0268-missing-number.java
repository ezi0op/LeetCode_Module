class Solution {
    public int missingNumber(int[] a) {
        int i=0;
        while(i<a.length){
            int correctIdx=a[i];
            if(a[i]<a.length&&a[i]!=a[correctIdx]){
                swap(a,i,correctIdx);
            }else{
                i++;
            }
        }
        for(int j=0;j<a.length;j++){
            if(a[j]!=j){
                return j;
            }
        }
        return a.length;
    }
    static void swap(int[] a,int f,int l){
        int temp=a[f];
        a[f]=a[l];
        a[l]=temp;
    }
}
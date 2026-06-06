class Solution {
    public int firstMissingPositive(int[] a) {
        int i=0;
        while(i<a.length){
            int c=a[i]-1;
            if(a[i]>0&&a[i]<=a.length&&a[i]!=a[c]){
                swap(a,i,c);
            }else{
                i++;
            }
        }
        for(int j=0;j<a.length;j++){
            if(a[j]!=(j+1)){
                return (j+1);
            }
        }
        return a.length+1;
        
    }

    static void swap(int[] a, int f, int l) {
        int temp = a[f];
        a[f] = a[l];
        a[l] = temp;
    }
}
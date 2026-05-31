class Solution {
    public void sortColors(int[] a) {
        boolean swap;

        for(int i=0;i<a.length-1;i++){
            swap=false;
            for(int j=1;j<a.length-i;j++){
                if(a[j]<a[j-1]){
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                    swap=true;
                }
            }
            if(!swap){
                break;
            }
        }
    }
}
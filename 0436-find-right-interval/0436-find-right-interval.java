class Solution {
    public int[] findRightInterval(int[][] a) {
        int[] res=new int[a.length];
        for(int i=0;i<a.length;i++){
            int end=a[i][1];
            int min=Integer.MAX_VALUE;
            int index=-1;
            for(int j=0;j<a.length;j++){
                int start=a[j][0];
                if(start>=end&&start<=min){
                    min=start;
                    index=j;
                }
            }
            res[i]=index;
        }
        return res;
    }
}
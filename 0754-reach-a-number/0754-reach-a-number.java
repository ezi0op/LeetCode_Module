class Solution {
    public int reachNumber(int t) {
        t=Math.abs(t);
           int sum=0;
           int step=0;
           while(sum<t||(sum-t)%2!=0)
           {
            step++;
            sum+=step;
           }
           return step;


        
    }
}
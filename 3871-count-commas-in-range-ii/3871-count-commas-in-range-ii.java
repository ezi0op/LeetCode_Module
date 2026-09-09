class Solution {
    public long countCommas(long n) {
         long com=0;
       for(long i=1000;i<=n;i*=1000){
        com+=n-i+1;
        if(i>n/1000){
            break;
        }
       }
        return com;
    }
}
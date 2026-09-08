class Solution {
    public int countCommas(int n) {
        int com=0;
        if(n<999){
            return 0;
        }else{
            com=n-999;
        }
        return com;
        
    }
}
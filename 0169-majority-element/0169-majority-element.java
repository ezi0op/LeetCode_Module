class Solution {
    public int majorityElement(int[] nums) {
        int c = 0;
        int num = 0;
        for (int a : nums) {
            if (c == 0) {
                num = a;
            }
            System.out.println(num);
            if(a==num){
                c++;
            }else{
                c--;
            }

        }
       
        return num;
    }
}
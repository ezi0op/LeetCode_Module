class Solution {
    public int numberOfSteps(int num) {
return reduce(num);
    }

    static int reduce(int a)
    {
           if(a==0){
            return a;
        }
        if(a%2==0){
            return 1+reduce(a/2);       }
return 1+reduce(a-1);
    }
}
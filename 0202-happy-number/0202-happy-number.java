class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSq(slow);
            fast = findSq(findSq(fast));

        }while(slow!=fast);
        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int findSq(int n) {
      
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            System.out.println(rem);
            sum = sum + rem * rem;
             System.out.println(sum);
            n = n / 10;
             System.out.println(n);
        }
        return sum;

    }
}
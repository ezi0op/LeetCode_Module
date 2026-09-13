class Solution {
    public long shadowPairs(int[] nums) {
     	        int n = nums.length;

        int[] navorelitu = nums;

        int[] stack = new int[n];
        int top = 0;

        long count = 0;

        for (int x : navorelitu) {

            // Remove values that x blocks
            while (top > 0 && stack[top - 1] > x) {
                top--;
            }

            // Every remaining value smaller than x
            // forms a shadow pair with x.
            int lo = 0;
            int hi = top;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (stack[mid] < x) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            count += lo;

            // Add current value
            stack[top++] = x;
        }

        return count;


    }
}
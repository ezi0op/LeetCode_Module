class Solution {
    public int sortableIntegers(int[] nums) {

        int n = nums.length;
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k == 0 && checkDrop(nums, k)) {
                ans += k;
            }
        }
        return ans;
    }

    private static boolean checkDrop(int[] nums, int k) {
        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += k) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            int drop = 0;
            for (int j = i; j < i + k;j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                int next = (j + 1 == i + k) ? i : j + 1;
                if (nums[j] > nums[next]) {
                    drop++;
                }
            }
            if (drop > 1 || prevMax > minVal) {
                return false;
            }
            prevMax = maxVal;
        }
        return true;
    }
}
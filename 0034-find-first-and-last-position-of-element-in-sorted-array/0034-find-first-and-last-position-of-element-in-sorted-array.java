class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[]={-1,-1};
        int s=binarySearch(nums,target,true);
        int e=binarySearch(nums,target,false);
        ans[0]=s;
        ans[1]=e;
        return ans;
    }

    private static int binarySearch(int[] a, int t, boolean findIndex) {
        int s = 0;
        int e = a.length - 1;
        int ans = -1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (t < a[m]) {
                e = m - 1;
            } else if (t > a[m]) {
                s = m + 1;
            } else {
                ans = m;
                if (findIndex) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
        }
        return ans;
    }
}
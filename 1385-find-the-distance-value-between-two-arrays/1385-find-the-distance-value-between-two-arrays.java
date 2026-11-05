class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
     
        for (int n : arr1) {   boolean found = true;
            for (int a : arr2) {
                if (Math.abs(n - a) <= d) {

                    found = false;
                    break;
                }
            }
            if (found) {

                count++;
            }
        }
        return count;
    }
}
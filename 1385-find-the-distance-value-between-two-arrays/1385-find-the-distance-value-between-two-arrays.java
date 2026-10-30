class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
		for (int num : arr1) {
			boolean found = false;
			for (int num2 : arr2) {
				if (Math.abs(num - num2) <= d) {

					found = true;
					break;
				}
			}
			if (!found) {
				count++;
			}
		}
		return count;
    }
}
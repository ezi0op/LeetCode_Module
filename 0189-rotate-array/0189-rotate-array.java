class Solution {
    public void rotate(int[] nums, int k) {
		int n = nums.length;

         k = k % n;

reverse(nums, 0, n - 1);
reverse(nums, 0, k - 1);
reverse(nums, k, n - 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	 static void reverse(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
}}
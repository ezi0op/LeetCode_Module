class Solution {
    public int[] frequencySort(int[] nums) {
        	int[] freq = new int[201];

		for (int num : nums) {
			freq[num + 100]++;
		}

		for (int i = 0; i < nums.length; i++) {
			int min = i;
			for (int j = i + 1; j < nums.length; j++) {
				int f1 = freq[nums[min] + 100];
				int f2 = freq[nums[j] + 100];
				if (f2 < f1 || (f1 == f2 && nums[j] > nums[min])) {
					min = j;
				}

			}
			int temp = nums[i];
			nums[i] = nums[min];
			nums[min] = temp;

		}

		return nums;
    }
}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);

		int closest = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int s = i + 1;
			int e = nums.length - 1;
			while (s < e) {
				int sum = nums[i] + nums[s] + nums[e];

				if (Math.abs(sum - target) < Math.abs(target - closest)) {

					closest = sum;
				}

				if (sum == target) {
					return sum;
				}
				if (sum < target) {
					s++;
				} else {
					e--;
				}

			}

		}
		return closest;
    }
}
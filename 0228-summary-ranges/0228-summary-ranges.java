class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
		int i = 0;
		while (i < nums.length) {
			int start = nums[i];
			int j = i;

			while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
				j++;
			}
			if (nums[j] == start) {
				ans.add(String.valueOf(nums[i]));
			} else {
				ans.add(start + "->" + nums[j]);
			}
			i = j + 1;
		}

		return ans;
    }
}
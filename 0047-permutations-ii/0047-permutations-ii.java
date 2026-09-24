class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    
		List<List<Integer>> ans = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return ans;
		}
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);
		permuteUniqueHelper(nums, used, list, ans);
		return ans;

	}

	private static void permuteUniqueHelper(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> ans) {
		if (list.size() == nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			list.add(nums[i]);
			permuteUniqueHelper(nums, used, list, ans);
			used[i] = false;

			list.remove(list.size() - 1);
		}

	}
}
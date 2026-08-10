class Solution {
   
	public static List<List<Integer>> combine(int n, int k) {

		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		List<List<Integer>> res = new ArrayList<>();
		combine(nums, k, 0, new ArrayList<>(), res);
		return res;

	}

	private static void combine(int[] nums, int k, int idx, List<Integer> ans, List<List<Integer>> res) {

		if (ans.size() == k) {

			res.add(new ArrayList<>(ans));
			return;
		}

		for (int i = idx; i < nums.length; i++) {
			ans.add(nums[i]);
			combine(nums, k, i + 1, ans, res);
			ans.remove(ans.size() - 1);

		}

	}

}
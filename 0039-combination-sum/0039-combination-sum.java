class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
  List<List<Integer>> ans =
		combinationSum(candidates, target, 0, new ArrayList<>());
		return ans;

	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target, int idx, List<Integer> ans) {
		List<List<Integer>> result = new ArrayList<>();
		if (target == 0) {
			result.add(new ArrayList<>(ans));
			return result;
		}
		if (target < 0 || idx == candidates.length) {
			return new ArrayList<>();
		}
		for (int i = idx; i < candidates.length; i++) {
			ans.add(candidates[i]);
			List<List<Integer>> res = combinationSum(candidates, target - candidates[i], i, ans);
			result.addAll(res);
			ans.remove(ans.size() - 1);

		}

		return result;
	}
}
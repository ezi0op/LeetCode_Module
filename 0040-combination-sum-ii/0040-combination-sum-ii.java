class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> ans = combinationSum2Helper(candidates, target, 0, new ArrayList<>());
        return ans;

    }

    private static List<List<Integer>> combinationSum2Helper(int[] candidates, int target, int idx,
            List<Integer> arrayList) {

        List<List<Integer>> ans = new ArrayList<>();
        if (target == 0) {
            ans.add(new ArrayList<>(arrayList));
            return ans;
        }
        if (target < 0 || idx == candidates.length) {
            return new ArrayList<>();
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            arrayList.add(candidates[i]);
            List<List<Integer>> res = combinationSum2Helper(candidates, target - candidates[i], i + 1, arrayList);
            ans.addAll(res);
            arrayList.remove(arrayList.size() - 1);
        }
        return ans;
    }

}
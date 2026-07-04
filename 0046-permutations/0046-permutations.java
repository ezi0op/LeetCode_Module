class Solution {

    static List<List<Integer>> permute(List<Integer> p, int[] up) {
		if (up.length == 0) {
			List<List<Integer>> ans = new ArrayList<>();
			ans.add(new ArrayList<>(p));
			return ans;
		}
		int current = up[0];
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i <= p.size(); i++) {
			List<Integer> first = new ArrayList<>(p.subList(0, i));
			List<Integer> second = new ArrayList<>(p.subList(i, p.size()));
			List<Integer> temp = new ArrayList<>();
			temp.addAll(first);
			temp.add(current);
			temp.addAll(second);
			ans.addAll(permute(temp, Arrays.copyOfRange(up, 1, up.length)));
		}
		return ans;
	}
    public List<List<Integer>> permute(int[] nums) {

		return permute(new ArrayList<>(), nums);
	}

	
}
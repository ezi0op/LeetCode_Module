class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
Arrays.sort(nums);
		return subsetWithDupUtil(new int[0], nums);
	}

	private static List<List<Integer>> subsetWithDupUtil(int[] p, int[] up) {

		if (up.length == 0) {
			List<List<Integer>> ans = new ArrayList<>();
			List<Integer> temp = new ArrayList<>();
			for (int x : p) {
				temp.add(x);
			}
			ans.add(temp);

			return ans;
		}
		int first = up[0];

		int[] include = Arrays.copyOf(p, p.length + 1);
		include[p.length] = first;

		List<List<Integer>> left = subsetWithDupUtil(include, Arrays.copyOfRange(up, 1, up.length));

		int i = 0;
		while (i + 1 < up.length && up[i] == up[i + 1]) {
			i++;
		}

		List<List<Integer>> right = subsetWithDupUtil(p, Arrays.copyOfRange(up, i + 1, up.length));
		left.addAll(right);

		return left;
	}
}
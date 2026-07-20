class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsetsArraysUtil(new int[0], nums);

    }

    private static List<List<Integer>> subsetsArraysUtil(int[] p, int[] up) {
        if (up.length == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int x : p) {
                temp.add(x);
            }
            ans.add(temp);
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();
        int first = up[0];
        int[] exclude = Arrays.copyOfRange(up, 1, up.length);
        int[] include = Arrays.copyOf(p, p.length + 1);
        include[p.length] = first;
        ans.addAll(subsetsArraysUtil(include, exclude));
        ans.addAll(subsetsArraysUtil(p, exclude));
        return ans;
    }

}
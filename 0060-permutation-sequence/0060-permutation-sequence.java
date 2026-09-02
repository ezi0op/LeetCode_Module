class Solution {
    public String getPermutation(int n, int k) {
  	List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		StringBuilder sb = new StringBuilder();
		int fact = 1;

		for (int i = 1; i < n; i++) {
			fact *= i;
		}
		k--;
		for (int i = 0; i < n; i++) {
			sb.append(nums.get(k / fact));
			nums.remove(k / fact);
			if (i < n - 1) {
				k %= fact;
				fact /= (n - 1 - i);
			}
		}
		return sb.toString();
	}
}
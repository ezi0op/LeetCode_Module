class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
		// rev the array
		for (int i = num.length - 1; i >= 0; --i) {
			// sum indx ele and k and mod of 10 giv dig sum and div of 10 giv carry for next
			// indx
			ans.add((num[i] + k) % 10);
			k = (num[i] + k) / 10;
		}
		// if k is greater than 0 then we will add the remaining digits of k to the ans
		// list
		while (k > 0) {
			ans.add(k % 10);
			k /= 10;
		}
        	Collections.reverse(ans);
		return ans;
    }
}
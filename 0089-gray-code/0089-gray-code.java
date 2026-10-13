class Solution {
    public List<Integer> grayCode(int n) {
        // here we are generating the gray code for a given number n
		int total = 1 << n;
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < total; i++) {
			// here we are using the formula for gray code which is i ^ (i >> 1)
			//means we are taking the XOR of the number and the number right shifted by 1
			int gray = i ^ (i >> 1);
			ans.add(gray);
		}
		return ans;
    }
}
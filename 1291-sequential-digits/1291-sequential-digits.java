class Solution {
    public List<Integer> sequentialDigits(int l, int h) {
      	List<Integer> ans = new ArrayList<>();
		String s = "123456789";
		int lowLen = String.valueOf(l).length();
		int highLen = String.valueOf(h).length();
		for (int len = lowLen; len <= highLen; len++) {
			for (int i = 0; i <= 9 - len; i++) {

				int num = Integer.parseInt(s.substring(i, i + len));
				if (num >= l && num <= h) {
					ans.add(num);
				}
			}
		}
		return ans;
    }
}
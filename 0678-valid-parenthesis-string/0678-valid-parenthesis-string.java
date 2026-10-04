class Solution {
    public boolean checkValidString(String s) {
       	int up = 0;
		int down = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				up++;
				down++;
			} else if (c == ')') {
				up--;
				down--;
			} else {
				up++;
				down--;
			}
			if (up < 0) {
				return false;
			}
			down = Math.max(down, 0);
		}
		return down == 0;
    }
}
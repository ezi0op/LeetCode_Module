class Solution {
    public String defangIPaddr(String a) {
    	char[] b = a.toCharArray();
		int c = 0;
		char[] ans = new char[a.length() * 3];
		for (int i = 0; i < b.length; i++) {
			if (b[i] == '.') {
				ans[c++] = '[';
				ans[c++] = '.';
				ans[c++] = ']';
			} else {
				ans[c++] = b[i];
			}
		}
		return new String(ans,0,c);
    }
}
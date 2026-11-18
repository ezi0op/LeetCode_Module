class Solution {
    public int minChanges(String s) {
       int count = 0;
		// traverse arr by 2
		for (int i = 0; i < s.length(); i += 2) {
			// check if current char is not equal to next char then we will increment count
			if (s.charAt(i) != s.charAt(i + 1)) {
				count++;
			}
		}
		return count;
 
    }
}
class Solution {
    public int maxDepth(String s) {
        int depth = 0;
		int result = 0;
		for (char c : s.toCharArray()) {
			if (c == ')') {
				depth--;
				continue;
			}
			if (c != '(') {
				continue;
			}
			depth++;
			result = Math.max(result, depth);
			
		}
		return result;
    }
}
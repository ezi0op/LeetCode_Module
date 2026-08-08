class Solution {
    public  String reverseParentheses(String s) {

		Stack<StringBuilder> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		if (s == null || s.length() == 0) {
			return "";
		}
		for (char c : s.toCharArray()) {

			if (c == '(') {
				stack.push(sb);
				sb = new StringBuilder();
			} else if (c == ')') {
				// reverse the string and append to the previous string
				sb.reverse();
				StringBuilder prev = stack.pop();
				prev.append(sb);
				sb = prev;

			} else {
				sb.append(c);
			}

		}

		return sb.toString();
	}

}
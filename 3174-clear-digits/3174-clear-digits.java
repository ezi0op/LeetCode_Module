class Solution {
    public String clearDigits(String s) {
     	Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(c);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Character c : stack) {
			sb.append(c);
		}

		return sb.toString();

	}
    
}
class Solution {
    public int maxDepth(String s) {
        int depth = 0;
		int result = 0;
        Stack<Character> stack=new Stack<>();
		for (char c : s.toCharArray()) {
			// if (c == ')') {
			// 	depth--;
			// 	continue;
			// }
			// if (c != '(') {
			// 	continue;
			// }
			// depth++;
//             if(c=='('){
//                 depth++;
// result = Math.max(result, depth);
//             }else if(c==')'){
//                 depth--;
//             }
	if (c == ')') {
				stack.push(c);
				result = Math.max(result, stack.size());
			} else if (!stack.isEmpty() && c == '(') {
				stack.pop();
			}
			
			
		}
		return result;
    }
}
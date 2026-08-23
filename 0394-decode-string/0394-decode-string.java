class Solution {
    public String decodeString(String s) {
        

		Stack<Integer> countStack = new Stack<>();
		Stack<String> stringStack = new Stack<>();
		StringBuilder currentString = new StringBuilder();
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int count = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					count = count * 10 + (s.charAt(i) - '0');
					i++;

				}

				countStack.push(count);
			} else if (ch == '[') {
				stringStack.push(currentString.toString());
				currentString = new StringBuilder();
				i++;
			} else if (ch == ']') {
				StringBuilder temp = new StringBuilder(stringStack.pop());
				int repeatTimes = countStack.pop();
				for (int j = 0; j < repeatTimes; j++) {
					temp.append(currentString);

				}
				currentString = temp;
				i++;
			} else {
				currentString.append(ch);
				i++;
			}
		}
		return currentString.toString();
    }
}
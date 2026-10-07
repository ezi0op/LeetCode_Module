class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
    	List<String> res = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.offer(s);
		visited.add(s);
		boolean found = false;
		while (!queue.isEmpty() && !found) {
			int size = queue.size();
			// iterate through the current level of strings
			for (int i = 0; i < size; i++) {
				String current = queue.poll();
				// if the current string is valid, add it to the result list and set found to
				// true
				if (isValid(current)) {
					res.add(current);
					found = true;
					continue;
				}

				// generate next level of strings by removing one parentheses at a time
				for (int j = 0; j < current.length(); j++) {
					// if the character is not a parentheses, continue to the next character
					if (current.charAt(j) != '(' && current.charAt(j) != ')') {
						continue;
					}
					String next = current.substring(0, j) + current.substring(j + 1);
					// if visited does not contain the next string, add it to the queue and visited
					// set
					if (!visited.contains(next)) {
						queue.offer(next);
						visited.add(next);
					}
				}

			}
		}
		return res;
	}

	// here we are using a counter to keep track of the balance of the parentheses
	boolean isValid(String s) {
		int balance = 0;
		for (char c : s.toCharArray()) {
			// if open parentheses is found, increment the balance
			if (c == '(') {
				balance++;
				// if closed parentheses is found, decrement the balance
			} else if (c == ')') {
				balance--;
			}
			// if balance is negative, return false
			if (balance < 0) {
				return false;
			}
		}
		// if balance is zero, return true, otherwise return false
		return balance == 0;
	}

}
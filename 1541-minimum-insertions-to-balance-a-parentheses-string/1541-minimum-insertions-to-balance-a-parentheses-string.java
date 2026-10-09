class Solution {
    public int minInsertions(String s) {
        int open = 0, ans = 0;
		for (int i = 0; i < s.length(); i++) {
			// if we found open parentheses, we increment the open counter
			if (s.charAt(i) == '(') {
				open++;
			} else {
				// if we found closed parentheses then we increment the index to skip a closed
				// parentheses if it is followed by another closed parentheses
				// i . e is make "))" as a pair
				if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
					i++;
				}
				//
				else {
					ans++;

				}
				// if we have an open parentheses, we decrement the open counter

				if (open > 0) {
					open--;
				}
				// if we don't have an open parentheses, we increment the answer counter
				else {
					ans++;
				}

			}
		}
		// we return the answer counter plus the open counter multiplied by 2, because
		// we need to add two closed parentheses for each open parentheses
		return ans + open * 2;

    }
}
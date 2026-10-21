class Solution {
   // given string s sorted in non-decreasing order
	public  int minOperations(String s) {

		boolean sorted = true;
		int n = s.length();
		// check if string already sorted then return 0
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) < s.charAt(i - 1)) {
				sorted = false;
				break;
			}
		}
		if (sorted) {
			return 0;
		}
		// len of string is 2 then return -1 as we can not make it sorted by any
		// operation
		if (n == 2) {
			return -1;
		}

		char min = 'z', max = 'a';

		char first = s.charAt(0), last = s.charAt(n - 1);

		// assing min and max char in string
		for (int i = 0; i < n; i++) {
			min = (char) Math.min(min, s.charAt(i));
			max = (char) Math.max(max, s.charAt(i));
		}

		// if first char is min or last char is max then we can make it sorted by one
		// operation
		if (first == min || last == max) {
			return 1;
		}
		// 3 ops needed if first char is min and last char is max then we can make it
		// sorted by two operations
			// sorted by two operations
		if (first == max && last == min) {
			int maxCount = 0, minCount = 0;
			for (int i = 0; i < n ; i++) {
				if(s.charAt(i)==max) {
					maxCount++;
				}
				if(s.charAt(i)==min) {
					minCount++;
				}
			}
			if(maxCount==1 && minCount==1) {
				return 3;
			}
		}

		// other wise we can make it sorted by two operations
		return 2;

	}
}
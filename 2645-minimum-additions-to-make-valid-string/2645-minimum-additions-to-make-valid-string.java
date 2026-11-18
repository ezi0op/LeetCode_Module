class Solution {
    public int addMinimum(String word) {
        int n = word.length(), res = 0, i = 0;
		while (i < n) {
			int count = 0;
			// check if current char is 'a' then we will increment count and move to next
			// char
			if (word.charAt(i) == 'a') {
				count++;
				i++;
			}
			// check if current char is 'b' then we will increment count and move to next
			// char
			if (i < n && word.charAt(i) == 'b') {
				count++;
				i++;
			}
			// check if current char is 'c' then we will increment count and move to next
			// char
			if (i < n && word.charAt(i) == 'c') {
				count++;
				i++;
			}
			// calculate the number of characters that need to be added to make the string
			// valid
			res += 3 - count;

		}
		return res;
    }
}
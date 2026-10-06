class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
			return s;
		}
		// first fill the rows with empty string builder
		StringBuilder[] rows = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			rows[i] = new StringBuilder();
		}
		int row = 0;
		// 1 = down ,-1=up
		int direction = 1;

		for (int i = 0; i < s.length(); i++) {
			// here we are appending the current character to the current row and then
			// updating the row and direction based on the current row
			rows[row].append(s.charAt(i));
			// if row =0 then go down
			if (row == 0) {
				direction = 1;
				// if row = numRows - 1 then go up
			} else if (row == numRows - 1) {
				direction = -1;
			}
			// update the row based on the direction
			row += direction;
		}
		// append all the rows to the result string builder and return the final result
		// as a string
		StringBuilder result = new StringBuilder();
		for (int i = 0; i <numRows; i++) {
			result.append(rows[i]);
		}
		return result.toString();
    }
}
class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid = new char[m][n];
		// Block every cell with '#' initially
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				grid[r][c] = '#';
			}
		}

		// Open entire first row with '.'
		for (int c = 0; c < n; c++) {
			grid[0][c] = '.';
		}
		// open entire last column with '.'
		for (int r = 0; r < m; r++) {
			grid[r][n - 1] = '.';
		}

		String res[] = new String[m];
		// Convert each row of the grid to a string and store it in the result array
		for (int r = 0; r < m; r++) {

			res[r] = new String(grid[r]);
		}
		return res;

    }
}
class Solution {
    public boolean hasValidPath(char[][] grid) {
     	int rows = grid.length;
		int cols = grid[0].length;
		// check for the first cell is valid or not
		if ((rows + cols - 1) % 2 != 0 || grid[0][0] == ')' || grid[rows - 1][cols - 1] == '(') {
			return false;
		}

		// take max balance as half of the total number of cells in the grid
		// to avoid the stack overflow error we can use a 3D array to keep track of the
		// visited cells and the balance of parentheses
		int maxBalance = (rows + cols-1) / 2;
		boolean[][][] visited = new boolean[rows][cols][maxBalance + 1];
		return hasValidPathHelper(grid, 0, 0, 0, rows, cols, maxBalance, visited);

	}

	private static boolean hasValidPathHelper(char[][] grid, int r, int c, int bal, int rows, int cols, int maxBal,
			boolean[][][] visited) {
		// we hav inc bal if we find ( and dec bal if we find )
		if (grid[r][c] == '(') {
			bal++;
		} else {
			bal--;
		}

		if (bal < 0 || bal > maxBal) {
			return false;
		}
		// check if we have reached the last cell and the balance is 0
		if (r == rows - 1 && c == cols - 1) {
			return bal == 0;
		}

		// check if we have already visited this cell with the same balance
		if (visited[r][c][bal]) {
			return false;
		}
		// mark this cell as visited with the current balance
		visited[r][c][bal] = true;
		// increment the row and check for next down cell if they are valid or not
		if (r + 1 < rows && hasValidPathHelper(grid, r + 1, c, bal, rows, cols, maxBal, visited)) {
			return true;
		}
		// increment the column and check for next right cell if they are valid or not
		if (c + 1 < cols && hasValidPathHelper(grid, r, c + 1, bal, rows, cols, maxBal, visited)) {
			return true;
		}

		return false;
	}
}
class Solution {
static final int MOD = 1_000_000_007;
	static int rows, cols;
	static int[][][] dp;

	// Given a 2D grid of size m x n, where each cell is either 0 (empty) or 1
	// (obstacle), return the number of unique paths from the top-left corner (0, 0)
	// to the bottom-right corner (m - 1, n - 1). You can only move either down or
	// right at any point in time. The answer should be returned modulo 10^9 + 7.
	public  int uniquePaths(int[][] grid) {
		rows = grid.length;
		cols = grid[0].length;

		dp = new int[rows][cols][2];
		// Fill array with -1 to indicate unvisited states
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		// Call the helper function for both directions (0 for right, 1 for down) and
		// return the sum of both results modulo MOD
		        return uniquePathsHelper(grid, 0, 0, 0);


	}

	private static int uniquePathsHelper(int[][] grid, int row, int col, int dir) {
		// Outside the grid, return 0
		if (row >= rows || col >= cols) {
			return 0;
		}

		// Destination Reached, return 1
		if (row == rows - 1 && col == cols - 1) {
			return 1;
		}

		// If the current cell is an obstacle, return 0
		if (dp[row][col][dir] != -1) {
			return dp[row][col][dir];
		}

		long ans = 0;
		// If the current cell is empty, we can move either right or down
		if (grid[row][col] == 0) {
		         ans = (uniquePathsHelper(grid, row, col + 1, 0)
                 + (long) uniquePathsHelper(grid, row + 1, col, 1)) % MOD;
		} else {
			// If the current cell is an obstacle, we can only move in the direction we came
			// from to avoid hitting the obstacle. If we came from the left (dir = 0), we
			// can only move down. If we came from above (dir = 1), we can only move right.
			if (dir == 0) {
				ans = uniquePathsHelper(grid, row + 1, col, 1);

			} else {
				ans = uniquePathsHelper(grid, row, col + 1, 0);
			}

		}

		return dp[row][col][dir] = (int) ans;
	}
}
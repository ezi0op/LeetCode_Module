class Solution {
    public int[][] largestLocal(int[][] grid) {
        int rows = grid.length;
		int cols = grid[0].length;
		int maxLocal[][] = new int[rows - 2][cols - 2];
		// iterating matrix but -2 because we are taking 3x3 matrix and we want to avoid
		// out of bounds error
		for (int r = 0; r < rows - 2; r++) {
			for (int c = 0; c < cols - 2; c++) {
				int max = 0;
				// itermatrix by +3 of row and col each position to get the 3x3 matrix and find
				// the max value of that matrix
				for (int i = r; i < r + 3; i++) {
					for (int j = c; j < c + 3; j++) {

						max = Math.max(max, grid[i][j]);

					}
				}
				maxLocal[r][c] = max;
			}
		}
		return maxLocal;

    }
}
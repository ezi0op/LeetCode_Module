class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        	if (n == 0 || grid == null || grid.length == 0 || grid[0].length == 0) {
			return grid;
		}

		int[][] temp1 = new int[n][n];
		for (int r = 0; r < n; r++) {

			for (int c = 0; c < n; c++) {
				int newCol = (c - rowShift[r] + n) % n;
				temp1[r][newCol] = grid[r][c];

			}

		}
		int[][] temp2 = new int[n][n];
		for (int r = 0; r < n; r++) {

			for (int c = 0; c < n; c++) {
				int newRow = (r - colShift[c] + n) % n;
				temp2[newRow][c] = temp1[r][c];
			}

		}
		return temp2;
    }
}
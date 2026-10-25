class Solution {
   public  int closedIsland(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {

				// if we find land then we check if it is a closed island or not
				if (grid[r][c] == 0) {
					// if closedIslandFinder returns true then we increment the count
					if (closedIslandFinder(grid, r, c, rows, cols)) {
						count++;
					}

				}
			}
		}

		return count;

	}

	private static boolean closedIslandFinder(int[][] grid, int r, int c, int rows, int cols) {
		// check for out of bounds or if we find water then we return false
		if (r < 0 || c < 0 || r >= rows || c >= cols) {

			return false;
		}
		// water : this direction does not lead to a closed island, so we return true
		if (grid[r][c] == 1) {
			return true;
		}
		// mark the current cell as visited by setting it to 1 (water)
		grid[r][c] = 1;
		// go up, down, left, and right to check if all directions lead to closed
		// islands
		boolean up = closedIslandFinder(grid, r - 1, c, rows, cols);
		boolean down = closedIslandFinder(grid, r + 1, c, rows, cols);
		boolean right = closedIslandFinder(grid, r, c - 1, rows, cols);
		boolean left = closedIslandFinder(grid, r, c + 1, rows, cols);
		return up && down && right && left;
	}
}
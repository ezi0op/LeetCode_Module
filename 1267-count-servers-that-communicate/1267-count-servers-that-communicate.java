class Solution {
   public  int countServers(int[][] grid) {
		int row = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[row][cols];
		int count = 0;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == 1 && !visited[r][c]) {
					int servers = countServersHelper(grid, r, c, row, cols, visited);

					if (servers > 1) {
						count += servers;
					}
				}
			}
		}
		return count;

	}

	private static int countServersHelper(int[][] grid, int r, int c, int row, int cols, boolean[][] visited) {
		if (r < 0 || c < 0 || r >= row || c >= cols) {
			return 0;
		}
		if (grid[r][c] == 0 || visited[r][c]) {
			return 0;
		}
		visited[r][c] = true;
		int count = 1;
		for (int col = 0; col < cols; col++) {
			if (!visited[r][col] && grid[r][col] == 1) {
				count += countServersHelper(grid, r, col, row, cols, visited);
			}
		}
		for (int rw = 0; rw < row; rw++) {
			if (!visited[rw][c] && grid[rw][c] == 1) {
				count += countServersHelper(grid, rw, c, row, cols, visited);
			}
		}

		return count;
	}
}
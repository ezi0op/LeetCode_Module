class Solution {
    public int countIslands(int[][] grid, int k) {
        
  
		int rows = grid.length;
		int cols = grid[0].length;
		boolean visited[][] = new boolean[rows][cols];
		int count = 0;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				// visited is false and grid is div by k then we call helper to traverse the
				// island and mark all the land as visited
				if (!visited[r][c] && grid[r][c] > 0) {
					long sum = countIslandsHelperII(grid, r, c, rows, cols, visited, k);
					if (sum % k == 0) {
						count++;
					}
				}
			}
		}
		return count;

	}

	private static long countIslandsHelperII(int[][] grid, int r, int c, int rows, int cols, boolean[][] visited,
			int k) {

		if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || grid[r][c]  == 0) {
			return 0;
		}

		// mark the current cell as visited
		visited[r][c] = true;
		long sum = grid[r][c];
		// go up, down, left, and right to traverse the island
		sum += countIslandsHelperII(grid, r - 1, c, rows, cols, visited, k);
		sum += countIslandsHelperII(grid, r + 1, c, rows, cols, visited, k);
		sum += countIslandsHelperII(grid, r, c - 1, rows, cols, visited, k);
		sum += countIslandsHelperII(grid, r, c + 1, rows, cols, visited, k);
		return sum;
	}


}
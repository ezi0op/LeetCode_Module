class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    traverseIsland(grid, r, c, m, n);
                }
            }
        }
        return count;

    }

    private static void traverseIsland(char[][] grid, int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        traverseIsland(grid, r + 1, c, m, n);
        traverseIsland(grid, r - 1, c, m, n);

        traverseIsland(grid, r, c + 1, m, n);
        traverseIsland(grid, r, c - 1, m, n);

    }
}
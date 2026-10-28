class Solution {
    boolean visited[][][];

    int minCost = Integer.MAX_VALUE;

    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols][1024];
        minCost = Integer.MAX_VALUE;
        minCostHelper(grid, 0, 0, 0);

        return minCost;
    }

    private void minCostHelper(int[][] grid, int row, int col, int xor) {
        int rows = grid.length;
        int cols = grid[0].length;

        xor ^= grid[row][col];
        if (visited[row][col][xor]) {
            return;
        }
        visited[row][col][xor] = true;
        if (row == rows - 1 && col == cols - 1) {
            minCost = Math.min(minCost, xor);
            return;
        }
        if (row + 1 < rows) {
            minCostHelper(grid, row + 1, col, xor);
        }
        if (col + 1 < cols) {
            minCostHelper(grid, row, col + 1, xor);
        }

    }

}
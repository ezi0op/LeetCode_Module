class Solution {
   static boolean[][] visit;

    public int[] lastVisitedCell(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        char[][] grids = grid;
            visit = new boolean[rows][cols];
        return lastVisiting(grids, 0, 0, rows, cols);
    }

     static int[] lastVisiting(char[][] grids, int r, int c, int rows, int cols) {
        visit[r][c] = true;
        int rw = r;
        int cl = c;
        if (grids[r][c] == 'L') {
            cl--;
        } else if (grids[r][c] == 'R') {
            cl++;
        } else if (grids[r][c] == 'U') {
            rw--;
        } else if (grids[r][c] == 'D') {
            rw++;
        }
        if (rw < 0 || cl < 0 || rw >= rows || cl >= cols) {
            return new int[] { r, c };
        }

        if (visit[rw][cl] == true) {
            return new int[] { r, c };
        }
        return lastVisiting(grids, rw, cl, rows, cols);
    }
}
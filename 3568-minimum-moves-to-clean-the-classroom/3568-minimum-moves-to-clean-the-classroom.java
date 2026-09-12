class Solution {
    public int minMoves(String[] g, int e) {
       	int m = g.length, n = g[0].length();
		int row = 0, col = 0, k = 0;
		int[][] id = new int[m][n];
		for (int[] rows : id) {
			Arrays.fill(rows, -1);
		}
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				char ch = g[r].charAt(c);
				if (ch == 'S') {
					row = r;
					col = c;
				} else if (ch == 'L') {
					id[r][c] = k++;
				}
			}
		}
		int all = (1 << k) - 1;
		int[][][] best = new int[m][n][1 << k];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				Arrays.fill(best[r][c], -1);
			}
		}

		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { row, col, e, 0 });
		best[row][col][0] = e;
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int moves = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int engery = cur[2];
				int mask = cur[3];

				// collect all the lights
				if (mask == all) {
					return moves;
				}
				if (engery == 0) {
					continue;
				}
				for (int[] d : dir) {
					int nr = r + d[0];
					int nc = c + d[1];
					if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
						continue;
					}
					if (g[nr].charAt(nc) == 'X') {
						continue;
					}

					int newEnergy = engery - 1;
					int newMask = mask;
					char ch = g[nr].charAt(nc);
					if (ch == 'L') {
						newMask |= 1 << id[nr][nc];
					}
					if (ch == 'R') {
						newEnergy = e;
					}

					if (newEnergy <= best[nr][nc][newMask]) {
						continue;
					}
					best[nr][nc][newMask] = newEnergy;
					q.offer(new int[] { nr, nc, newEnergy, newMask });

				}

			}
			moves++;

		}
		return -1;
    }
}
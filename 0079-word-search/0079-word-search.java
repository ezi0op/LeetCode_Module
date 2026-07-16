class Solution {
   public  boolean exist(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;
		StringBuilder sb = new StringBuilder();
		boolean[][] visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (existHelper(board, word, i, j, visited, sb)) {
					return true;
				}
			}
		}

		return false;

	}

	private static boolean existHelper(char[][] maze, String word, int r, int c, boolean[][] visited,
			StringBuilder sb) {
		if (r >= maze.length || c >= maze[0].length || r < 0 || c < 0) {
			return false;
		}
		if (visited[r][c]) {
			return false;
		}

		sb.append(maze[r][c]);

		if (!word.startsWith(sb.toString())) {
			sb.deleteCharAt(sb.length() - 1);
			return false;
		}

		if (sb.toString().equals(word)) {
			sb.deleteCharAt(sb.length() - 1);
			return true;
		}
		visited[r][c] = true;

		boolean found = existHelper(maze, word, r + 1, c, visited, sb) || existHelper(maze, word, r - 1, c, visited, sb)
				|| existHelper(maze, word, r, c + 1, visited, sb) || existHelper(maze, word, r, c - 1, visited, sb);
		visited[r][c] = false;
		sb.deleteCharAt(sb.length() - 1);
		return found;

	}

}
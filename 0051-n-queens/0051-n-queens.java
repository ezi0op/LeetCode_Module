class Solution {
    public List<List<String>> solveNQueens(int n) {

  return solveNQueensHelper(new boolean[n][n], 0);

	}

	private static List<List<String>> solveNQueensHelper(boolean[][] board, int row) {
		if (row == board.length) {

			List<List<String>> res = new ArrayList<>();
			List<String> temp = new ArrayList<>();
			for (boolean[] arr : board) {
				StringBuilder sb = new StringBuilder();
				for (boolean element : arr) {
					sb.append(element ? 'Q' : '.');
				}
				temp.add(sb.toString());
			}
			res.add(temp);
			return res;
		}
		List<List<String>> res = new ArrayList<>();

		for (int col = 0; col < board.length; col++) {
			if (isSafeQ(board, row, col)) {
				board[row][col] = true;
				res.addAll(solveNQueensHelper(board, row + 1));
				board[row][col] = false;
			}
		}
		return res;
	}

	private static boolean isSafeQ(boolean[][] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i][col]) {
				return false;
			}
		}
		int maxLeft = Math.min(row, col);
		for (int i = 1; i <= maxLeft; i++) {
			if (board[row - i][col - i]) {
				return false;
			}
		}

		int maxRight = Math.min(row, board.length - col - 1);
		for (int i = 1; i <= maxRight; i++) {
			if (board[row - i][col + i]) {
				return false;
			}
		}
		return true;
	}
}
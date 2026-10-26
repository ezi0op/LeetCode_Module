class Solution {
    public List<List<String>> solveNQueens(int n) {

	boolean[][] board = new boolean[n][n];
		List<List<String>> res = new ArrayList<>();

		queenSLeetCode(board, 0, res);
		return res;

	}

	private static int queenSLeetCode(boolean[][] queenBoard, int row, List<List<String>> result) {

		// if we have placed queens in all the rows then we will add the board to the
		// result and return 1
		if (row == queenBoard.length) {
			List<String> resultList = new ArrayList<>();

			for (boolean[] rows : queenBoard) {
				StringBuilder sb = new StringBuilder();
				// here we are converting the boolean array to string and adding it to the
				// result list
				// if element is true then we will add Q else we will add . to the string
				for (boolean element : rows) {
					sb.append(element ? "Q" : ".");
				}
				resultList.add(sb.toString());

			}
			result.add(resultList);
			return 1;
		}
		int count = 0;
		// placing queen and checking for every row and col
		for (int cols = 0; cols < queenBoard.length; cols++) {
			// place the queen if it is safe to place the queen or not
			if (isSafeQueenSLeetCode(queenBoard, row, cols)) {
				queenBoard[row][cols] = true;

				count += queenSLeetCode(queenBoard, row + 1, result);
				queenBoard[row][cols] = false;

			}
		}
		return count;
	}

	private static boolean isSafeQueenSLeetCode(boolean[][] queenBoard, int rows, int cols) {
		// checlk for vertical row
		for (int r = 0; r < rows; r++) {
			// if board is true then there means queen is present there in that cell
			if (queenBoard[r][cols]) {
				return false;
			}
		}
		// check for diagonal left
		int maxLeft = Math.min(rows, cols);
		for (int i = 1; i <= maxLeft; i++) {
			// here we are decreasing both row and col by 1 to check the diagonal left of
			// the current cell
			if (queenBoard[rows - i][cols - i]) {
				return false;
			}
		}
		// check for diagonal right
		int maxRight = Math.min(rows, queenBoard.length - cols - 1);
		for (int i = 1; i <= maxRight; i++) {
			// here we are decreasing row by 1 and increasing col by 1 to check the diagonal
			// right of the current cell
			if (queenBoard[rows - i][cols + i]) {
				return false;
			}
		}
		return true;
	}

}
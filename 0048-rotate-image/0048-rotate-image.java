class Solution {
    public void rotate(int[][] matrix) {
        int s = 0;
		int e = matrix.length - 1;
		// first swap the first row with the last row and second row with the second
		// last row and so on
		while (s < e) {
			int temp[] = matrix[s];
			matrix[s] = matrix[e];
			matrix[e] = temp;
			s++;
			e--;
		}
		// then we swap the elements of the matrix diagonally
		for (int i = 0; i < matrix.length; i++) {
			// here we are swapping the elements of the matrix diagonally
			for (int j = i + 1; j < matrix[0].length; j++) {
				// first get val of i and j to temp
				int temp = matrix[i][j];
				// then val of j and i to i and j
				matrix[i][j] = matrix[j][i];
				// then val of temp to j and i
				matrix[j][i] = temp;
			}
		}
    }   
}
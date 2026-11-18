class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(n * m != original.length) {
			return new int[0][0];
		}
      int[][] ans = new int[m][n];

		for (int i = 0; i < original.length; i++) {
			// here we are calculating the row and column index of the 2d array from the 1d
			// array
			// with using of formula row=i/n and col=i%n
			ans[i / n][i % n] = original[i];
		}
		return ans;  
    }
}
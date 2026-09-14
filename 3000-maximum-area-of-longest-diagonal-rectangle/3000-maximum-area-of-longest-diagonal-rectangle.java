class Solution {
    public int areaOfMaxDiagonal(int[][] d) {
        	int maxD = 0;
		int maxArea = 0;
		for (int[] a : d) {
			int diagonal = a[0] * a[0] + a[1] * a[1];
			int area = a[0] * a[1];
			if (diagonal > maxD) {
				maxD = diagonal;
				maxArea = area;
			} else if(diagonal==maxD) {
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
    }
}
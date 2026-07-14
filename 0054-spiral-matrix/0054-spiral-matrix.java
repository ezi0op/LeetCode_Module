class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        	int s = 0;
		int e = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		ArrayList<Integer> result = new ArrayList<>();
		while (s <= e&& left <= right) {
			for (int i = left; i <= right; i++) {
				result.add(matrix[s][i]);
			}
			s++;
			for (int i = s; i <= e; i++) {
				result.add(matrix[i][right]);
			}
			right--;
			if (s <= e) {
				for (int i = right; i >= left; i--) {
					result.add(matrix[e][i]);

				}
				e--;
			}
			if (left <= right) {
				for (int i = e; i >= s; i--) {
					result.add(matrix[i][left]);
				}
				left++;
			}

		}
		return result;

    }
}
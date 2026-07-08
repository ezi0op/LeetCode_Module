class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        for (int i = 0; i < a.length; i++) {
			int s = 0;
			int e = a[0].length - 1;
			while (s <= e) {
				int mid = s + (e - s) / 2;

				if (a[i][mid] == target) {
					return true;
				}

				if (a[i][mid] < target) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}

			}
		}
		return false;
    }
}
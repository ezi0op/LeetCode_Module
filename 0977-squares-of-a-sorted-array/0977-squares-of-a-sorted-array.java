class Solution {
    public int[] sortedSquares(int[] a) {
     int[] ans = new int[a.length];
		int s = 0;
		int e = a.length - 1;
		int p = a.length - 1;
		while (s <= e) {
			if (Math.abs(a[s]) > Math.abs(a[e])) {
				ans[p] = a[s] * a[s];
				s++;
			} else {
				ans[p] = a[e] * a[e];
				e--;
			}
			p--;
		}
		return ans;
      
    }
}
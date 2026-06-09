class Solution {
   public int minEatingSpeed(int[] a, int t) {
		int l = 1;
		int h = 0;
		for (int i : a) {
			h = Math.max(h, i);
		}

		while (l < h) {
			int m = l + (h - l) / 2;
			long hrs = 0;
			for (int i : a) {
				hrs += i / m;
				if (i % m != 0) {
					hrs++;
				}

			}
			if (hrs <= t) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		return l;

	}
}
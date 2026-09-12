class Solution {
  static class Interval {
		int l, r, w, idx;

		Interval(int l, int r, int w, int idx) {
			this.l = l;
			this.r = r;
			this.w = w;
			this.idx = idx;
		}
	}

	static class State {
		long score;
		List<Integer> indices;

		State(long score, List<Integer> indices) {
			this.score = score;
			this.indices = indices;
		}
	}

	public static int[] maximumWeight(List<List<Integer>> intervals) {

		int n = intervals.size();

		Interval[] a = new Interval[n];

		for (int i = 0; i < n; i++) {
			a[i] = new Interval(intervals.get(i).get(0), intervals.get(i).get(1), intervals.get(i).get(2), i

			);
		}

		Arrays.sort(a, (x, y) -> {
			if (x.r != y.r) {
				return Integer.compare(x.r, y.r);
			}
			return Integer.compare(x.l, y.l);
		});

		int[] ends = new int[n];

		for (int i = 0; i < n; i++) {
			ends[i] = a[i].r;
		}

		State[][] dp = new State[5][n + 1];

		for (int k = 0; k <= 4; k++) {
			dp[k][0] = new State(0, new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			Interval currInterval = a[i - 1];
			int j = lowerBound(ends, currInterval.l, i - 1);

			for (int k = 0; k <= 4; k++) {
				// Don't take current interval
				State best = dp[k][i - 1];

				if (k > 0) {

					State previous = dp[k - 1][j];

					long newScore = previous.score + currInterval.w;

					List<Integer> newIndices = new ArrayList<>(previous.indices);

					newIndices.add(currInterval.idx);

					Collections.sort(newIndices);

					State take = new State(newScore, newIndices);

					if (better(take, best)) {
						best = take;
					}
				}

				dp[k][i] = best;
			}
		}
		 List<Integer> answer = dp[4][n].indices;

	        return answer.stream()
	                .mapToInt(Integer::intValue)
	                .toArray();

	}

	// Return true if a is better than b
	static boolean better(State a, State b) {

		if (a.score != b.score) {
			return a.score > b.score;
		}

		// Same score → lexicographically smaller
		return lexicographicallySmaller(a.indices, b.indices);
	}

	static boolean lexicographicallySmaller(List<Integer> a, List<Integer> b) {

		int n = Math.min(a.size(), b.size());

		for (int i = 0; i < n; i++) {

			if (!a.get(i).equals(b.get(i))) {
				return a.get(i) < b.get(i);
			}
		}

		// If one is a prefix of the other,
		// shorter array is lexicographically smaller.
		return a.size() < b.size();
	}

	private static int lowerBound(int[] ends, int target, int r) {
		int left = 0;
		while (left < r) {
			int mid = left + (r - left) / 2;
			if (ends[mid] < target) {
				left = mid + 1;
			} else {
				r = mid;
			}
		}
		return left;
	}

}
class Solution {
    public int[][] merge(int[][] intervals) {
        	// sort the intervals based on the start time of each interval
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		// take a list of integer array to store the merged intervals
		List<int[]> merged = new ArrayList<>();

		// start with the first interval and loop through the intervals
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {

			// take next start and end of the interval
			int nextStart = intervals[i][0];
			int nextEnd = intervals[i][1];

			// check if nextStart is less then or equal to end if then we assign max of end
			// to end
			if (nextStart <= end) {
				end = Math.max(end, nextEnd);
				// if nextstart is greater then end then we add the current interval to the
				// merged list and update start and end to nextStart and nextEnd
			} else {
				// add the current interval to the merged list
				merged.add(new int[] { start, end });
				// update start and end to nextStart and nextEnd
				start = nextStart;
				end = nextEnd;

			}

		}
		// add the last interval to the merged list
		merged.add(new int[] { start, end });
		// convert the merged list to an array and return it
		return merged.toArray(new int[merged.size()][]);
    }
}
class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
		int prev = -1;
		int curr = 0;
		while (n > 0) {
			// check if the current bit is 1
			if ((n & 1) == 1) {
				// if prev is not -1, we calculate the distance between the current position and
				// the previous position and update maxGap if necessary
				if (prev != -1) {
					maxGap = Math.max(maxGap, curr - prev);
				}
				// update prev to the current position
				prev = curr;
			}
			// right shift n by 1 to check the next bit and increment curr to keep track of
			// the current position
			n = n >> 1;
			curr++;
		}
		return maxGap;
    }
}
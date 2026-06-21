class Solution {
    public int splitArray(int[] a, int k) {
     int s = 0;
		int e = 0;
		// find the maximum element in the array and sum of all elements in the array
		// max ele is s and sum of all ele is e
		for (int max : a) {
			s = Math.max(s, max);
			e += max;
		}
		// go until s is less than e
		while (s < e) {
			// find mid ele as potential answer for highest sum of sub array
			int m = s + (e - s) / 2;
			int sum = 0;
			// start pieces as 1 because we are counting the number of sub array we are
			// splitting the array into
			int pieces = 1;
			// loop each ele from array a
			for (int num : a) {
				// if sum and each ele is greater than mid then we are splitting the array into
				// 2 pieces and assign sum as num because we are starting new sub array
				if (sum + num > m) {
					// increase the pieces by 1 because we are splitting the array into 2 pieces
					pieces++;
					sum = num;

					// if sum and each ele is less than mid then we are adding the ele to sum
					// because we are not splitting the array
				} else {
					sum += num;
				}
			}
			// pieces is greater than k then we need to increase the mid because we are
			// splitting the
			if (pieces > k) {
				s = m + 1;
				// pieces is less than or equal to k then we need to decrease the mid because we
				// are splitting the array into less than or equal to k pieces
			} else {
				e = m;
			}
		}
		return s;

    }
}
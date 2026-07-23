class Solution {
    public int thirdMax(int[] nums) {
   	// taking long firstMax, secondMax and thirdMax to store the first, second and
		// third maximum number in the given array
		// reason for taking long is because if the array contains Integer.MIN_VALUE
		// then it will be considered as third maximum number and we will return
		// Integer.MIN_VALUE instead of the maximum number in the given array
		long firstMax = Long.MIN_VALUE;
		long secondMax = Long.MIN_VALUE;
		long thirdMax = Long.MIN_VALUE;
		for (int num : nums) {
			// first checek for the duplicate number in the given array if it is present
			// then we will continue to the next number
			if (num == firstMax || num == secondMax || num == thirdMax) {
				continue;
			}
			// if the number is greater than the first maximum number then we will update
			// the first maximum number, second maximum number and third maximum number
			if (num > firstMax) {
				// first assign second maximum number to third maximum number and first maximum
				// number to second maximum number and then assign the current number to first
				// maximum number
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = num;
				// if the number is greater than the second maximum number then we will update
				// the second maximum number and third maximum number
			} else if (num > secondMax) {
				// first assign second maximum number to third maximum number and then assign
				// the
				// current number to second maximum number
				thirdMax = secondMax;
				secondMax = num;
			} else if (num > thirdMax) {
				// if the number is greater than the third maximum number then we will update
				// the
				// third maximum number
				thirdMax = num;
			}
		}

		// if the third maximum number is not present then we will return the first
		// maximum number otherwise we will return the third maximum number
		return (int) (thirdMax == Long.MIN_VALUE ? firstMax : thirdMax);
    }
}
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), start = new HashMap<>(), end = new HashMap<>();
		int degree = 0, ans = nums.length;

		for (int i = 0; i < nums.length; i++) {

			int num = nums[i];
			// count freq of each element in array
			freq.put(num, freq.getOrDefault(num, 0) + 1);
			// if start map does not contain the element then we will add it to the start
			// map with its index
			if (!start.containsKey(num)) {
				start.put(num, i);
			}
			end.put(num, i);
			// update the degree of the array
			degree = Math.max(degree, freq.get(num));
		}
		// using entry key set we are iterating through the frequency map and checking
		// if the frequency of the element is equal to the degree of the array. If it is
		// then we will update the answer with the minimum length of the subarray with
		// the same degree as the original array.
		for (int num : freq.keySet()) {
			if (freq.get(num) == degree) {
				ans = Math.min(ans, end.get(num) - start.get(num) + 1);
			}
		}

		return ans;
    }
}
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		Set<Integer> set3 = new HashSet<>();

		// add all the elements of nums1, nums2, and nums3 to their respective sets
		for (int num : nums1) {
			set1.add(num);
		}
		for (int num : nums2) {
			set2.add(num);
		}
		for (int num : nums3) {
			set3.add(num);
		}
		// create a HashMap to store the frequency of each element across the three sets
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : set1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int num : set2) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int num : set3) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Integer> ans = new ArrayList<>();
		// By using entrySet() method we are iterating through the map and checking if
		// the value of the entry is greater than or equal to 2, if it is then we will
		// add the key to the ans list
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= 2) {
				ans.add(entry.getKey());

			}
		}
		return ans;

    }
}
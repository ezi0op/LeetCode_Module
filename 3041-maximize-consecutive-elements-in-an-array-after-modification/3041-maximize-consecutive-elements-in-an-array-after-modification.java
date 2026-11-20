class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for (int num : nums) {

			// keep curr num unchangeed
			int keep = map.getOrDefault(num - 1, 0) + 1;
			// increase curr num by 1
			int increase = map.getOrDefault(num, 0) + 1;

			// update the seq length for the current number and the next number in the map
			map.put(num, Math.max(map.getOrDefault(num, 0), keep));

			// update the seq length for the next number in the map
			map.put(num + 1, Math.max(map.getOrDefault(num + 1, 0), increase));
			ans = Math.max(ans, Math.max(map.get(num), map.get(num + 1)));

		}
		return ans;
    }
}
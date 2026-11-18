class Solution {
    public int minDeletion(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// if map size less than or equal to k then we don't need to delete any
		// character
		if (map.size() <= k) {
			return 0;
		}

		// get all val and sort them and get remove size and add all the least freq to
		// count
		List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list);
		int count = 0;
		int remove = list.size() - k;
		for (int i = 0; i < remove; i++) {
			count += list.get(i);
		}

		return count;
    }
}
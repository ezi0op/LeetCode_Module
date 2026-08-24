class Solution {
    public String reorganizeString(String s) {
        	// count the frequency of each character in the given string and store it in a
		// hashmap
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// if the maximum frequency of any character is greater than half of the length
		// of the string then it is not possible to reorganize the string
		int maxCount = Collections.max(map.values());
		if (maxCount > (s.length() + 1) / 2) {
			return "";
		}

		// make a priority queue to store the characters in the given string based on
		// their frequency in descending order
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		pq.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		Map.Entry<Character, Integer> prev = null;
		while (!pq.isEmpty()) {
			Map.Entry<Character, Integer> curr = pq.poll();
			sb.append(curr.getKey());
			curr.setValue(curr.getValue() - 1);
			if (prev != null && prev.getValue() > 0) {
				pq.offer(prev);
			}
			prev = curr;
		}

		return sb.toString();
    }
}
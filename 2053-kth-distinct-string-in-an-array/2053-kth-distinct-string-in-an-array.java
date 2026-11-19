class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
		for (String s : arr) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		for (String s : arr) {
			// check if the frequency of the current string is 1, which means it is distinct
			// and decrement k. If k reaches 0, we return the current string as the kth
			// distinct string.
			if (map.get(s) == 1) {
				k--;
				if (k == 0) {
					return s;
				}
			}
		}

		return "";

    }
}
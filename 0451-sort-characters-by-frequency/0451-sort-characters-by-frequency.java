class Solution {
    public String frequencySort(String s) {
        // count the frequency of each character in the given string and store it in a
		// hashmap
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// sort the hashmap based on the frequency of each character in descending order
		// and store it in a list of map entriesS
		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> b.getValue() - a.getValue());
		StringBuilder sb = new StringBuilder();

		// loop through the list of map entries and append the character to the string
		// builder
//map entry returns one key and one value and we are appending back to string builder here
		for (Map.Entry<Character, Integer> entry : list) {
			char c = entry.getKey();
			int freq = entry.getValue();
			for (int i = 0; i < freq; i++) {
				sb.append(c);
			}

		}
		return sb.toString();

    }
}
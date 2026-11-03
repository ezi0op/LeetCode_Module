class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
		Map<String, Integer> map = new HashMap<>();

		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> {
			if (!a.getValue().equals(b.getValue())) {
				return b.getValue() - a.getValue();
			}
			return a.getKey().compareTo(b.getKey());
		});
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(list.get(i).getKey());
		}
		return ans;

	
    }
}
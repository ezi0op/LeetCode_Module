class Solution {
   public static List<Integer> findSubstring(String s, String[] words) {

		if (words.length == 0 || s.length() == 0) {
			return new ArrayList<>();
		}
		List<Integer> ans = new ArrayList<>();
		int wordLen = words[0].length();
		int wordCount = words.length;
		int totalLen = wordLen * wordCount;
		Map<String, Integer> expected = new HashMap<>();
		for (String word : words) {
			expected.put(word, expected.getOrDefault(word, 0) + 1);
		}
		for (int offset = 0; offset < wordLen; offset++) {
			int left = offset;
			int count = 0;
			Map<String, Integer> currMap = new HashMap<>();
			for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
				String word = s.substring(right, right + wordLen);

				if (!expected.containsKey(word)) {
					currMap.clear();
					count = 0;
					left = right + wordLen;
					continue;
				}
				currMap.put(word, currMap.getOrDefault(word, 0) + 1);
				count++;
				while (currMap.get(word) > expected.get(word)) {

					String leftWord = s.substring(left, left + wordLen);
					currMap.put(leftWord, currMap.get(leftWord) - 1);
					count--;
					left += wordLen;
				}
				if (count == wordCount) {
					ans.add(left);
					String leftWord = s.substring(left, left + wordLen);
					currMap.put(leftWord, currMap.get(leftWord) - 1);
					left += wordLen;
					count--;
				}

			}

		}
		return ans;

	}
}
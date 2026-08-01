class Solution {
   public  String sortVowels(String s) {
		char[] arr = s.toCharArray();
		List<Character> vowels = new ArrayList<>();
		Map<Character, Integer> freq = new HashMap<>();
		Map<Character, Integer> index = new HashMap<>();
		// store frequency of vowels in the given string and store the index of vowels
		// in the given string
		for (char c : arr) {
			if (isVowel(c)) {
				vowels.add(c);
				freq.put(c, freq.getOrDefault(c, 0) + 1);
				index.putIfAbsent(c, vowels.size() - 1);
			}
		}

		Collections.sort(vowels, (a, b) -> {
			if (!freq.get(a).equals(freq.get(b))) {
				return freq.get(b) - freq.get(a);
			}
			return index.get(a) - index.get(b);
		});

		int idx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (isVowel(arr[i])) {
				arr[i] = vowels.get(idx++);
			}
		}

		return new String(arr);

	}
    private static boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) != -1;
}
}
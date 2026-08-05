class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
		boolean isValid = true;
		for (String word : words) {
			isValid = true;
			for (char c : word.toCharArray()) {
				if (!allowed.contains(String.valueOf(c))) {

					isValid = false;
					break;
				}
			}
			if (isValid) {
				count++;
			}
		}
		return count;
    }
}
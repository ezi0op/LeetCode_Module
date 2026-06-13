class Solution {
 public List<String> printVertically(String s) {
		// first split strng by space and store in string arr
		String[] arr = s.split(" ");

		List<String> ans = new ArrayList<>();
		int maxLen = 0;
		// find max length of string arr and we will how many time we hav to print the
		// char by char here
		for (String word : arr) {
			// math max method to find the max length of string in arr
			maxLen = Math.max(maxLen, word.length());
		}
		// first loop for length of max length of string in arr
		for (int i = 0; i < maxLen; i++) {
			// to manipulate string
			StringBuilder sb = new StringBuilder();
			// loop throgh each string in array
			for (String word : arr) {
				// if i less than length of string we will append i char of string
//				other wise we will append space there
				if (i < word.length()) {
					sb.append(word.charAt(i));
				} else {
					sb.append(" ");
				}
			}

			// we hac to remove the trailing spce at string builder
			// we hac to print string char by char by removing the trailing spce at end
			while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
				sb.deleteCharAt(sb.length() - 1);
			}
			// add the string builder to ans list as string
			ans.add(sb.toString());

		}
		return ans;

	}
}
class Solution {
   static TreeSet<String> ans = new TreeSet<>();

	// here we are finding the brace expansion of the given string using recursion
	private static void braceExpansionDFS(String s) {
		int r = s.indexOf('}');

		// no braces left, add to ans
		if (r == -1) {
			ans.add(s);
			return;
		}
		// get the index of the last opening brace before the closing brace
		int l = s.lastIndexOf('{', r);
		// split the string into left and right parts of the braces
		String left = s.substring(0, l);
		// right part of the string after the closing brace
		String right = s.substring(r + 1);

		// split the options inside the braces and recursively call the function for
		// each option
		// content inside the braces
		String inside = s.substring(l + 1, r);
		// split the options inside the braces and recursively call the function for
		// each option
		for (String part : inside.split(",")) {

			// recursively call the function for each option and add the left and right
			// parts of the string
			braceExpansionDFS(left + part + right);

		}

	}

	public static List<String> braceExpansionII(String expression) {
        ans.clear();
		braceExpansionDFS(expression);
		return new ArrayList<>(ans);

	}
}
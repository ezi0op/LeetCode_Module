class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
		List<String> e = new ArrayList();
		List<String> g = new ArrayList();
		List<String> p = new ArrayList();
		List<String> r = new ArrayList();
		for (int i = 0; i < isActive.length; i++) {
			if (isActive[i]) {

				// check if the business line is one of the valid business lines and then check
				// if the code is valid
				if (businessLine[i].equals("electronics") || businessLine[i].equals("grocery")
						|| businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant")) {
					if (code[i].length() == 0) {
						continue;
					}
					boolean found = true;
					// check if the code contains only letters, digits and underscores
					for (int j = 0; j < code[i].length(); j++) {
						char ch = code[i].charAt(j);
						if (!Character.isLetterOrDigit(ch) && ch != '_') {
							found = false;
							break;
						}
					}

					// if found is truee then we will add the code to the corresponding business
					// line list based on the first character of the business line
					if (found) {
						if (businessLine[i].startsWith("e")) {
							e.add(code[i]);
						}
						if (businessLine[i].startsWith("g")) {
							g.add(code[i]);
						}
						if (businessLine[i].startsWith("p")) {
							p.add(code[i]);
						}
						if (businessLine[i].startsWith("r")) {
							r.add(code[i]);
						}
					}

				}
			}

		}
		// sort the lists of codes for each business line and then add them to the final
		// answer list
		Collections.sort(e);
		Collections.sort(g);
		Collections.sort(p);
		Collections.sort(r);

		ans.addAll(e);
		ans.addAll(g);
		ans.addAll(p);
		ans.addAll(r);
		return ans;
    }
}
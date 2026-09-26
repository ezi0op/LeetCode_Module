class Solution {
    public String evaluate(String s, List<List<String>> k) {
        HashMap<String, String> map = new HashMap<>(k.size());
		for (List<String> a : k) {
			map.put(a.get(0), a.get(1));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				int cl = s.indexOf(')', i + 1);
				String key = s.substring(i + 1, cl);
				sb.append(map.getOrDefault(key, "?"));
				i = cl;
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
    }
}
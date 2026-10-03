class Solution {
    public String[] findWords(String[] words) {

        String a = "qwertyuiop";
        String b = "asdfghjkl";
        String c = "zxcvbnm";
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (isInRow(word, a) || isInRow(word, b) || isInRow(word, c)) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);

    }

    private static boolean isInRow(String word, String a) {
        for (char c : word.toCharArray()) {
            if (!a.contains(String.valueOf(c).toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        generateParenthesis(0, 0, "", n, res);
        return res;
    }

    static void generateParenthesis(int open, int close, String s, int n, List<String> res) {

        if (s.length() == 2 * n) {

            res.add(s);
        }

        if (open < n) {

            generateParenthesis(open + 1, close, s + "(", n, res);

        }
        if (close < open) {
            generateParenthesis(open, close + 1, s + ")", n, res);

        }

    }

}
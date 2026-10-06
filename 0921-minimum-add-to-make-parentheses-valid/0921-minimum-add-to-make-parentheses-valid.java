class Solution {
    public int minAddToMakeValid(String s) {
        int add = 0;
        int opening = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {

                opening++;
            } else {

                if (opening > 0) {
                    opening--;

                } else {
                    add++;
                }
            }
        }
        return add + opening;

    }
}
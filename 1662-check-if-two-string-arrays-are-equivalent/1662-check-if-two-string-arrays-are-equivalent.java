class Solution {
    public boolean arrayStringsAreEqual(String[] a, String[] b) {
        int i = 0;
        int j = 0;
        int x = 0;
        int y = 0;
        while (i < a.length && j < b.length) {
            if (a[i].charAt(x) != b[j].charAt(y)) {
                return false;

            }
            x++;
            y++;
            if (x == a[i].length()) {
                i++;
                x = 0;
            }
            if (y == b[j].length()) {
                j++;
                y = 0;

            }
           
        } return i == a.length && j == b.length;
    }
}
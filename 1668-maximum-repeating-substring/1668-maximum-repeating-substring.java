class Solution {
    public int maxRepeating(String x, String y) {
        int a = 0;
        String r = y;
        while (x.contains(r)) {
            a++;
            r += y;

        }
        return a;

    }
}
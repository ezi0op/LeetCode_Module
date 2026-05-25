class Solution {
    public char nextGreatestLetter(char[] a, char target) {
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target < a[m]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return a[s % a.length];

    }
}
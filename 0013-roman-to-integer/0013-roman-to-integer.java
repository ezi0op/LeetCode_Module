class Solution {
    

    public int romanToInt(String s) {
int b = 0;
        for (int i = 0; i < s.length(); i++) {
            int curVal = value(s.charAt(i));
            if (i < s.length()-1 && curVal < value(s.charAt(i + 1))) {
                b = b - curVal;
            } else {
                b = b + curVal;
            }
        }
        return b;
    }

    private int value(char s) {
        if (s=='I') {
            return 1;
        } else if (s=='V') {
            return 5;
        } else if (s=='X') {
        return 10;
        } else if (s=='L') {
            return 50;
        } else if (s=='C') {
            return 100;
        } else if (s=='D') {
            return 500;
        } else if (s=='M') {
            return 1000;
        }
        return 0;
       
    }
}

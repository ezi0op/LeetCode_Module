class Solution {
    public boolean repeatedSubstringPattern(String s) {
    	 return helper(s, 1);
}

private boolean helper(String s, int len) {
    if (len > s.length() / 2) {
        return false;
    }

    String p = s.substring(0, len);

    if (check(p, s, 0)) {
        return true;
    }

    return helper(s, len + 1);
}

private boolean check(String p, String s, int index) {
    if (index == s.length()) {
        return true;
    }

    if (!s.startsWith(p, index)) {
        return false;
    }

    return check(p, s, index + p.length());
}

}
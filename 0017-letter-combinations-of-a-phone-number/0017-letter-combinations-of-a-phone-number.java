class Solution {
    public List<String> letterCombinations(String p) {
          if (p.isEmpty()) {
            return new ArrayList<>();
        }
        return let("", p);
    }

    static List<String> let(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> l = new ArrayList<>();
            l.add(p);
            return l;
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();

        int start;
        int end;

        if (digit == 7) {
            start = (digit - 2) * 3;
            end = start + 4;
        } else if (digit == 8) {
            start = (digit - 2) * 3 + 1;
            end = start + 3;
        } else if (digit == 9) {
            start = (digit - 2) * 3 + 1;
            end = start + 4;
        } else {
            start = (digit - 2) * 3;
            end = start + 3;
        }




        for (int i =start; i < end; i++) {
            char ch = (char) ('a' + i);
            list.addAll(let(p + ch, up.substring(1)));
        }
        return list;

    }
}
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int a = s.length();
        boolean[] f = new boolean[a];
        f[0] = true;
        int farthest = 0;
        for (int i = 0; i < a; i++) {
            if (!f[i]) {
                continue;
            }
            int start = Math.max(i + minJump, farthest + 1);
            int end = Math.min(i + maxJump, a - 1);
            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    f[j] = true;
                }
            }
            farthest = end;
        }
        return f[a - 1];
    }
}
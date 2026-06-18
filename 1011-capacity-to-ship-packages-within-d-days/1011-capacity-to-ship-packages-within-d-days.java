
class Solution {
    public int shipWithinDays(int[] a, int t) {
        int s = 0;
        int e = 0;

        for(int b:a){
            s=Math.max(s,b);
            e+=b;
        }
        while (s < e) {
            int m = s + (e - s) / 2;
            if (canShip(a, t, m)) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    static boolean canShip(int[] a, int t, int m) {
        int x = 1;
        int y = 0;
        for (int w : a) {
            if (y + w > m) {
                x++;
                y = w;
            } else {
                y += w;
            }
        }
        return x <= t;
    }
}
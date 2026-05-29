class Solution {
    public int search(int[] a, int t) {
        int pivot = findPivot(a);
        if (pivot == -1) {
            return bsa(a, 0, a.length - 1, t);
        }
        if (a[pivot] == t) {
            return pivot;
        }

        if (t >= a[0]) {
            return bsa(a, 0, pivot - 1, t);
        }
        return bsa(a, pivot + 1, a.length - 1, t);
    }

    static int bsa(int[] a, int s, int e, int t) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (a[m] == t) {
                return m;
            } else if (t < a[m]) {
                e = m - 1;
            } else if (t > a[m]) {
                s = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    static int findPivot(int[] a) {
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m < e && a[m] > a[m + 1]) {
                return m;
            }
            if (m > s && a[m] < a[m - 1]) {
                return m - 1;
            }
            if (a[m] <= a[s]) {
                e = m - 1;
            } else if (a[m] >= a[s]) {
                s = m + 1;
            }
        }
        return -1;
    }
}
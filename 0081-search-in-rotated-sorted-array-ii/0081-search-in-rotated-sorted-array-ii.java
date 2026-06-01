class Solution {
    public boolean search(int[] a, int target) {
        int pivot = pivot(a);
        if (pivot == -1) {
            return bsa(a, 0, a.length - 1, target)>=0;
        }
        if (a[pivot] == target) {
            return true;
        }
        if (target >= a[0]) {
            return bsa(a, 0, pivot - 1, target)>=0;
        }
        return bsa(a, pivot + 1, a.length - 1, target)>=0;
    }

    static int pivot(int[] a) {
        int s = 0;
        int e = a.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m < e && a[m] > a[m + 1]) {
                return m;
            } else if (m > s && a[m] < a[m - 1]) {
                return m - 1;
            }

            if (a[m] == a[e] && a[m] == a[s]) {
                if (s+1<=e&&a[s] > a[s + 1]) {
                    return s;
                }
                s++;
                if (e-1>=s&&a[e] < a[e - 1]) {
                    return e - 1;
                }
                e--;
            } else if (a[s] < a[m] || (a[s] == a[m] && a[s] > a[e])) {
                s = m + 1;
            } else {
                e = m - 1;
            }

        }
        return -1;
    }

    static int bsa(int[] a, int s, int e, int t) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (t < a[m]) {
                e = m - 1;
            } else if (t > a[m]) {
                s = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

}

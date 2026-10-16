
class Solution {
    static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long[] sum = new long[4 * n];
        long[] sumSq = new long[4 * n];
        long[] lazy = new long[4 * n];

        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int prev = last[x];
            last[x] = i + 1;

            // Increase distinct counts for subarrays
            // ending at i, whose starting indices are [prev, i].
            update(1, 0, n - 1, prev, i, sum, sumSq, lazy);

            // Sum of squared distinct counts of all
            // subarrays ending at index i.
            ans = (ans + sumSq[1]) % MOD;
        }

        return (int) ans;
    }

    private void apply(int node, int l, int r,
                       long v, long[] sum,
                       long[] sumSq, long[] lazy) {
        long len = r - l + 1L;

        sumSq[node] = (sumSq[node]
                + 2L * v % MOD * sum[node] % MOD
                + len % MOD * v % MOD * v % MOD) % MOD;

        sum[node] = (sum[node] + len * v) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }

    private void push(int node, int l, int r,
                      long[] sum, long[] sumSq, long[] lazy) {
        if (lazy[node] == 0 || l == r) return;

        int mid = (l + r) / 2;
        apply(node * 2, l, mid, lazy[node], sum, sumSq, lazy);
        apply(node * 2 + 1, mid + 1, r,
              lazy[node], sum, sumSq, lazy);

        lazy[node] = 0;
    }

    private void update(int node, int l, int r,
                        int ql, int qr,
                        long[] sum, long[] sumSq, long[] lazy) {
        if (ql > r || qr < l) return;

        if (ql <= l && r <= qr) {
            apply(node, l, r, 1, sum, sumSq, lazy);
            return;
        }

        push(node, l, r, sum, sumSq, lazy);

        int mid = (l + r) / 2;
        update(node * 2, l, mid, ql, qr, sum, sumSq, lazy);
        update(node * 2 + 1, mid + 1, r,
               ql, qr, sum, sumSq, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
    }
}

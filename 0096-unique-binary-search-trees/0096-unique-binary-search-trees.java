class Solution {
    public int numTrees(int n) {
        long comb = 1;

        for (int i = 1; i <= n; i++) {
            comb = comb * (n + i) / i;
        }

        return (int) (comb / (n + 1));
    }

}
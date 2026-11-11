class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
    return Math.max(bound(need1, cost1, need2, cost2, costBoth), bound(need2, cost2, need1, cost1, costBoth));
	}

	private static long bound(long needA, int costA, long needB, int costB, int costBoth) {
		// here we are calculating the minimum cost to buy a certain number of items,
		// where we can either buy each item individually or buy both items together at
		// a discounted price. We will calculate the minimum cost for both scenarios and
		// return the maximum of the two.
		// a takes full price and b get whatever left price
		int pA = Math.min(costA, costBoth);
		int pB = Math.min(costB, costBoth - pA);
		return needA * pA + needB * pB;
	}
}
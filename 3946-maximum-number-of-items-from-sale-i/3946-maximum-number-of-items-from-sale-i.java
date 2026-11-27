class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
		int minPrice = Integer.MAX_VALUE;

		// dp[c] = maximum number of items that can be bought with budget c
		int[] dp = new int[budget + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		// finding cheapest item price from the items array
		for (int[] item : items) {
			minPrice = Math.min(minPrice, item[1]);
		}

		// 0/1 knapsack problem to find maximum number of items that can be bought with
		// budget
		for (int i = 0; i < n; i++) {
			int factor = items[i][0];
			int price = items[i][1];

			// count items recevied from buing this item once,
			// including purchased item itself
			int count = 0;

			// by doing mod of factor we are checking if the item can be bought with the
			// budget or not
			for (int j = 0; j < n; j++) {
				if (items[j][0] % factor == 0) {
					count++;
				}
			}

			// buy the item and update the dp array with the maximum number of items that
			// can be bought with the budget
			for (int c = budget; c >= price; c--) {
				if (dp[c - price] != -1) {
					dp[c] = Math.max(dp[c], dp[c - price] + count);
				}
			}
		}
		int ans = 0;
		// finding the maximum number of items that can be bought with the budget
		for (int c = 0; c <= budget; c++) {
			if (dp[c] != -1) {
				int total = dp[c] + (budget - c) / minPrice;
				ans = Math.max(ans, total);
			}
		}
		return ans;

    }
}
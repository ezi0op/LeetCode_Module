class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
       int n = items.length;
		// counting the frequency of each item based on their factor and price
		int[] freq = new int[n + 1];
		int minPrice = Integer.MAX_VALUE;

		// finding the minimum price of the items
		for (int[] item : items) {
			freq[item[0]]++;
			minPrice = Math.min(minPrice, item[1]);
		}

		// calculate how many free items each factor can generate based on the budget
		// and the price of the item
		int[] gain = new int[n + 1];

		for (int f = 1; f <= n; f++) {
			int count = 0;
			// counting the frequency of each item based on their factor and price
			for (int j = f; j <= n; j += f) {
				count += freq[j];
			}
			gain[f] = count - 1;
		}

		// collect profitable double value pruchases
		// each entry = {prive,maximum useful purchases}
		List<int[]> deals = new ArrayList<>();

		for (int[] item : items) {
			int factor = item[0];
			int price = item[1];

			// a double value purchase is profitable if the gain is greater than 0 and the
			// price is less than or equal to the budget
			if (gain[factor] > 0 && (long) price <= 2L * minPrice) {
				deals.add(new int[] { price, gain[factor] });
			}

		}
		// process cheaper deals first, so we sort the deals by price in ascending order
		deals.sort((a, b) -> Integer.compare(a[0], b[0]));

		long ans = 0;
		for (int[] deal : deals) {
			int price = deal[0];
			int count = deal[1];
			// we can buy at most count items with the given budget, so we take the minimum
			// of count and budget/price
			int buy = (int) Math.min((long) count, budget / price);
			ans += 2L * buy;
			// we subtract the cost of the purchased items from the budget
			budget -= (int) ((long) buy * price);
		}
		ans += budget / minPrice;
		return (int) ans;

    }
}
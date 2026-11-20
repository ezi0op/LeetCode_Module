class Solution {
    public int distributeCandies(int[] candyType) {
      Set<Integer> set = new HashSet<>();
		int n = candyType.length;
		for (int i = 0; i < n; i++) {
			set.add(candyType[i]);
		}
		int m = set.size();
		// min btween unique candies and half of the total candies
		return Math.min(m, n / 2);  
    }
}
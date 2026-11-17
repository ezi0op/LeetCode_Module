class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;

		// get sum of both arrays
		for (int a : aliceSizes) {
			sumA += a;
		}
		for (int b : bobSizes) {
			sumB += b;
		}
		// diff btw req for alice and bob
		int diff = (sumB - sumA) / 2;
		// store bobs box
		HashSet<Integer> setB = new HashSet<>();
		for (int b : bobSizes) {
			setB.add(b);
		}
		// if alice gives x to bob then bob should give y to alice such that x-y = diff
		// => y = x-diff
		for (int x : aliceSizes) {
			int y = x + diff;
			if (setB.contains(y)) {
				return new int[] { x, y };
			}
		}
		return new int[] {};

    }
}
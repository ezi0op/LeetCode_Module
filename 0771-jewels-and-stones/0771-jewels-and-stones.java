class Solution {
    public int numJewelsInStones(String jewels, String stones) {
      int count = 0;
		for (int i = 0; i < stones.length(); i++) {
			// if jewel is present in stones then we will increment count
			if (jewels.indexOf(stones.charAt(i)) != -1) {
				count++;
			}
		}

		return count;  
    }
}
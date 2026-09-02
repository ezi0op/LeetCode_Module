class Solution {
    public boolean uniformArray(int[] nums1) {
       	boolean hasOdd = false;
		for (int i = 0; i < nums1.length; i++) {
			if (nums1[i] % 2 != 0) {
				hasOdd = true;
				break;
			}
		}

		if (!hasOdd) {
			return true;
		}
		return true; 
    }
}
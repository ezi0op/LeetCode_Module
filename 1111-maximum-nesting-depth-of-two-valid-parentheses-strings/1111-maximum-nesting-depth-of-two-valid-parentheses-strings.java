class Solution {
    public int[] maxDepthAfterSplit(String seq) {
      int depth = 0;
		int[] arr = new int[seq.length()];

		for (int i = 0; i < seq.length(); i++) {
			if (seq.charAt(i) == '(') {
				depth++;
				arr[i] = depth % 2;
			} else {
				arr[i] = depth % 2;
				depth--;

			}
		}
		return arr;  
    }
}
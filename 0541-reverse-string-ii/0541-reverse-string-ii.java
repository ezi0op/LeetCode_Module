class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
		int step = 2 * k;
		// run loop with every step jump
		for (int i = 0; i < arr.length; i += step) {
			// assign i to left and min of i+k-1 and s.length()-1 to right and then swap the
			// elements at left and right until left is less than right
			int left = i;
			int right = Math.min(i + k - 1, arr.length - 1);
			// swap characters at left and right
			while (left < right) {
				char temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return new String(arr);

    }
}
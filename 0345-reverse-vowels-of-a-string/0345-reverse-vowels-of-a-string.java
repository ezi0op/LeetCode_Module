class Solution {
   	public static String reverseVowels(String s) {
		char[] arr = s.toCharArray();
		int l = 0;
		int h = arr.length - 1;
		while (l < h) {
			if (!isVowel(arr[l])) {
				l++;
			} else if (!isVowel(arr[h])) {
				h--;
			}
			 else {
				char temp = arr[l];
				arr[l] = arr[h];
				arr[h] = temp;
				l++;
				h--;
			}

		}
		return new String(arr);

	}

	private static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U';
	}

}
class Solution {
    public String reversePrefix(String word, char ch) {
        int c = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                c = i;
                break;
            }
        }
        int s = 0;
        int e = c;
        char[] arr = word.toCharArray();
        while (s < e) {
            swapChar(arr, s, e);
            s++;
            e--;
        }
        return new String(arr);
    }

    private static void swapChar(char[] arr, int f, int l) {
        char temp = arr[f];
        arr[f] = arr[l];
        arr[l] = temp;

    }
}
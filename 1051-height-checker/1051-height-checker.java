class Solution {
    public int heightChecker(int[] a) {
        int[] temp = a.clone();

      for (int i = 0; i < temp.length - 1; i++) {
    for (int j = 0; j < temp.length - i - 1; j++) {
        if (temp[j] > temp[j + 1]) {
            swapHeight(temp, j, j + 1);
        }
    }
}

        int count = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] != temp[j]) {
                count++;
            }
        }
        return count;

    }

    static void swapHeight(int[] a, int first, int last) {
        int temp = a[first];
        a[first] = a[last];
        a[last] = temp;

    }
}
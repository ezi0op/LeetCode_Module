class Solution {
    public List<Integer> findDuplicates(int[] a) {
        List<Integer> b = new ArrayList<>();
        int i = 0;
        while (i < a.length) {
            int c = a[i] - 1;
            if (a[i] != a[c]) {
                swap(a, i, c);
            } else {
                i++;
            }
        }
        for(int j=0;j<a.length;j++){
            if(a[j]!=(j+1)){
                b.add(a[j]);
            }
        }
        return b;

    }

    static void swap(int[] a, int f, int l) {
        int temp = a[f];
        a[f] = a[l];
        a[l] = temp;
    }
}
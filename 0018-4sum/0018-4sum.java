class Solution {
    public List<List<Integer>> fourSum(int[] b, int t) {
        List<List<Integer>> a = new ArrayList<>();
        Arrays.sort(b);
        int n=b.length;
        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && b[i] == b[i - 1]) {
                continue;
            }
            for (int j = i+1; j < n - 2; j++) {

                if (j > i + 1 && b[j] == b[j - 1]) {
                    continue;
                }
                int s = j + 1;
                int e = n - 1;
                while (s < e) {

                    long sum = (long) b[i] + b[s] + b[j] + b[e];
                    if (sum == t) {
                        a.add(Arrays.asList(b[i], b[j], b[s], b[e]));
                        s++;
                        e--;
                        while (s < e && b[s] == b[s - 1]) {
                            s++;
                        }
                        while (s < e && b[e] == b[e + 1]) {
                            e--;
                        }

                    } else if (sum < t) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }

        }
        return a;
    }
}
class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length;
        int[][] temp = new int[n][2];

        for (int i = 0; i < n; i++) {
            temp[i][0] = nums[i];

            temp[i][1] = digitSum(nums[i]);
        }
        Arrays.sort(temp, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(temp[i][0], i);
        }
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = map.get(nums[i]);
        }
        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || pos[i] == i) {
                continue;
            }
            int j = i;
            int cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = pos[j];
                cycleSize++;

            }
            count += cycleSize - 1;
        }
        return count;
    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
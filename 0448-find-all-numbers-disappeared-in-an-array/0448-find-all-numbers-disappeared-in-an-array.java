class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> a = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i]-1;
            if (nums[i]!=nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }

        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                a.add(j+1);
            }
        }
        return a;

    }

    static void swap(int[] nums, int f, int l) {
        int temp = nums[f];
        nums[f] = nums[l];
        nums[l] = temp;
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();
		// int count = 0;
		// for (int num : nums) {
		// 	map.put(num, map.getOrDefault(num, 0) + 1);
		// 	if (map.get(num) <= 2) {
		// 		nums[count] = num;
		// 		count++;
		// 	}
		// }
		// return count;
        int k = 2;

		// here we are iterating through the array and checking if the current element
		// is not equal to the element at index k-2 then we will assign the current
		// element to the element at index k and increment k by 1
		for (int i = 2; i < nums.length; i++) {
			// if the current element is not equal to the element at index k-2 then we will
			// assign the current element to the element at index k and increment k by 1
			if (nums[i] != nums[k - 2]) {
				nums[k] = nums[i];
				k++;
			}
		}
		return k;
    }
}
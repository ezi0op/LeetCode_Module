class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];

		// counint[] freq = new int[1001];

		// count the frequency of each element in arr1 and store it in the freq array
		for (int num : arr1) {
			freq[num]++;
		}
		int index = 0;
		// iterate through arr2 and for each element, add it to the result array as many
		// times as it appears in arr1
		for (int num : arr2) {
			while (freq[num] > 0) {
				
				// correctly overite the position
				arr1[index++] = num;
			
				// decrement the frequency of the current element in the freq array
				freq[num]--;
			}

		}
		// iterate through the freq array and add any remaining elements to the result
		// array in ascending order
		for (int i = 0; i <= 1000; i++) {
			while (freq[i] > 0) {
				arr1[index++] = i;
				freq[i]--;
			}
		}
		return arr1;

    }
}
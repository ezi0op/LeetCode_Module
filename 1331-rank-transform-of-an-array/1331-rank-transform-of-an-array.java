class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
    
		int n = arr.length;
		int[] res = new int[n];

		int[] temp = arr.clone();
		// store the index of each element in the given array arr in a HashMap where the
		// key is the element and the value is a list of indices where that element
		// occurs
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.putIfAbsent(arr[i], new ArrayList<>());
			map.get(arr[i]).add(i);
		}
		// sort the temp array in non-decreasing order using merge sort
		mergeSort(temp, 0, n - 1);

		int rank = 0;
		// check for each element in the sorted array temp and assign the rank to the
		// corresponding indices in the result array res based on the original indices
		// stored in the HashMap
		for (int i = 0; i < n; i++) {
			if (i == 0 || temp[i] != temp[i - 1]) {
				rank++;
			}
			for (int idx : map.get(temp[i])) {
				res[idx] = rank;
			}
		}
		return res;

	}

	// here we are implementing the merge sort algorithm to sort the given array
	// temp in non-decreasing order
	private static void mergeSort(int[] temp, int left, int right) {
		if (left >= right) {
			return;
		}
		// get mid of arr
		int mid = left + (right - left) / 2;
		// call mergeSort recusively from left to mid and mid+1 to right and then merge
		// the two sorted halves
		mergeSort(temp, left, mid);
		mergeSort(temp, mid + 1, right);
		merge(temp, left, mid, right);
	}

	// here we are merging two sorted halves of the given array temp from left to
	// mid and mid+1 to right
	private static void merge(int[] temp, int left, int mid, int right) {
		int[] res = new int[temp.length];
		int i = left, j = mid + 1, k = 0;
		// if i less then mid and j less then right
		while (i <= mid && j <= right) {
			// check if temp i is less then equal to temp j then we will add temp i to res
			if (temp[i] <= temp[j]) {
				res[k++] = temp[i++];
				// check if temp j is less then temp i then we will add temp j to res
			} else {
				res[k++] = temp[j++];
			}
		}
		// if i less then mid then we will add temp i to res
		while (i <= mid) {
			res[k++] = temp[i++];
		}
		// if j less then right then we will add temp j to res
		while (j <= right) {
			res[k++] = temp[j++];
		}
		// copy the sorted res array to temp array from left to right
		for (int x = 0; x < k; x++) {
			temp[left + x] = res[x];
		}

	}
}
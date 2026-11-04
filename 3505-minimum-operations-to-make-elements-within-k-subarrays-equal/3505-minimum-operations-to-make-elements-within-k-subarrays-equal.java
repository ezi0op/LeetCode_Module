class Solution {
   TreeMap<Integer, Integer> left = new TreeMap<>();
	 TreeMap<Integer, Integer> right = new TreeMap<>();
	 int leftSize = 0, rightSize = 0;
	 long leftSum = 0, rightSum = 0;

	// here we are adding the given key to the given TreeMap and updating its value
	// based on whether the key already exists in the map or not
	 void add(TreeMap<Integer, Integer> map, int key) {
		map.put(key, map.getOrDefault(key, 0) + 1);
	}

	// here we are moving given key if its count is 1 then we will remove it from
	// the map else we will decrement its count by 1
	 void remove(TreeMap<Integer, Integer> map, int key) {
		int count = map.get(key);
		if (count == 1) {
			map.remove(key);
		} else {
			map.put(key, count - 1);
		}
	}

	// here we are balancing the left and right TreeMaps by moving elements between
	// them

	 void balance() {
		// if left is grater than right then we will move the largest element from left
		// to right and update the sums and sizes accordingly
		while (leftSize > rightSize + 1) {
			int key = left.lastKey();
			remove(left, key);
			leftSum -= key;
			leftSize--;
			add(right, key);
			rightSum += key;
			rightSize++;
		}
		// if left is smaller than right then we will move the smallest element from
		// right to left and update the sums and sizes accordingly
		while (leftSize< rightSize ) {
			int key = right.firstKey();
			remove(right, key);
			rightSum -= key;
			rightSize--;
			add(left, key);
			leftSum += key;
			leftSize++;
		}
	}

	// here we are inserting the given value into either the left or right TreeMap
	// based on its value and updating the sums and sizes accordingly
	 void insert(int val) {
		// if size is 0 or val is less than or equal to the largest key in left then we
		// will add val to left and update leftSum and leftSize accordingly
		if (leftSize == 0 || val <= left.lastKey()) {
			add(left, val);
			leftSum += val;
			leftSize++;
		} else {
			// if val is greater than the largest key in left then we will add val to right
			// and update rightSum and rightSize accordingly
			add(right, val);
			rightSum += val;
			rightSize++;
		}
		balance();

	}

// here we are erasing the given value from either the left or right TreeMap based on its value and updating the sums and sizes accordingly
	 void erase(int val) {
		// if left contains val then we will remove it from left and update leftSum and
		// leftSize accordingly
		if (left.containsKey(val)) {
			remove(left, val);
			leftSum -= val;
			leftSize--;
		} else {
			// if right contains val then we will remove it from right and update rightSum
			// and rightSize accordingly
			remove(right, val);
			rightSum -= val;
			rightSize--;
		}
		balance();
	}

	// here we are calculating the cost of making all elements in the left and right
	// TreeMaps equal to the median value
	 long getCost() {
		long median = left.lastKey();
		// calculate the cost of making all elements in the left TreeMap equal to the
		// median value and adding it to the cost of making all elements in the right
		// TreeMap equal to the median value
		return (median * leftSize - leftSum) + (rightSum - median * rightSize);

	}

	// here we are finding the minimum number of operations required to make all
	// elements in the given array nums equal to the median value for each window of
	// size k and returning the result as a long integer
	public  long minOperations(int[] nums, int x, int k) {
		int n = nums.length;
		long[] cost = new long[n - x + 1];
		// here we are inserting the first k elements of the given array nums into the
		// left and right TreeMaps and calculating the cost of making all elements equal
		// to the median value
		for (int i = 0; i < x; i++) {
			insert(nums[i]);
		}
		cost[0] = getCost();
		// here we using erase and insert methods to update the left and right TreeMaps
		// as we slide the window of size k through the array nums and calculating the
		// cost of making all elements equal to the median value for each window
		for (int i = 1; i <= n - x; i++) {
			erase(nums[i - 1]);
			insert(nums[i + x - 1]);
			cost[i] = getCost();
		}

		long INF = Long.MAX_VALUE / 4;

		// take prev and curr arrays to store the minimum cost of making all elements
		// equal to the median value for each window of size k in the array nums
		long[] prev = new long[n + 1];
		long[] curr = new long[n + 1];

		for (int t = 1; t <= k; t++) {

			// fill the curr array with INF to initialize it for the current iteration
			Arrays.fill(curr, INF);

			for (int i = 1; i <= n; i++) {

				// skip curr element
				curr[i] = curr[i - 1];

				// take the current element if it is possible to take it and update the curr
				// array with the minimum cost of making all elements equal to the median value
				// for the current window
				if (i >= x && prev[i - x] != INF) {

					// calculate the cost of making all elements equal to the median value for the
					// current window and adding it to the minimum cost of making all elements equal
					// to the median value for the previous window
					long take = prev[i - x] + cost[i - x];

					curr[i] = Math.min(curr[i], take);
				}
			}

			// swap prev and curr arrays for the next iteration
			long[] temp = prev;
			prev = curr;
			curr = temp;
		}

		return prev[n];
    }
}
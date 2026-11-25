class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        
    int n = nums.length;
		int low = 1, high = n;
		int ans = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isUniqueSubarray(nums, mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
        
        System.out.println(isUniqueSubarray(new int[]{2, 1, 32}, 1));
System.out.println(isUniqueSubarray(new int[]{2, 1, 32}, 2));
System.out.println(isUniqueSubarray(new int[]{2, 1, 32}, 3));
		return ans;

	}


	private static boolean isUniqueSubarray(int[] nums, int k) {
		long mod1 = 1000000007L;
		long mod2 = 1000000009L;
		long base = 100001L;
		long n = nums.length;
		long pow1 = 1, pow2 = 1;
		for (int i = 1; i < k; i++) {

			pow1 = ((pow1 * base) % mod1);
			pow2 = ((pow2 * base) % mod2);
		}

		long h1 = 0, h2 = 0;
		for (int i = 0; i < k; i++) {
			h1 = (h1 * base + nums[i]) % mod1;
			h2 = (h2 * base + nums[i]) % mod2;
		}

		Map<String, Integer> freq = new HashMap<>();

		freq.put(h1 + "#" + h2, 1);

		for (int i = k; i < n; i++) {

		h1 = (h1 - nums[i-k] * pow1 % mod1 + mod1) % mod1;
h1 = (h1 * base + nums[i]) % mod1;

h2 = (h2 - nums[i-k] * pow2 % mod2 + mod2) % mod2;
h2 = (h2 * base + nums[i]) % mod2;

			String key = h1 + "#" + h2;
			freq.put(key, freq.getOrDefault(key, 0) + 1);
		}

		for (int count : freq.values()) {
			if (count == 1) {
				return true;
			}
		}

		return false;
	}
}
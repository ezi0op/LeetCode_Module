class Solution {
    public int beautifulSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		return beautifulSubsetsUtil(new int[0], nums, k) - 1;

	}

	private static int beautifulSubsetsUtil(int[] p, int[] up, int target) {

		if (up.length == 0) {
			return 1;
		}

		boolean isBeautiful = true;

		int first = up[0];
		
		
		for(int a:p) {
			if(Math.abs(a-first)==target) {
				isBeautiful=false;
				break;
			}
		}

		int left = 0;

		if (isBeautiful) {
			int[] include = Arrays.copyOf(p, p.length + 1);
			include[p.length] = first;
			left = beautifulSubsetsUtil(include, Arrays.copyOfRange(up, 1, up.length), target);

		}

		int right = beautifulSubsetsUtil(p, Arrays.copyOfRange(up, 1, up.length), target);

		return left + right;

	}
}
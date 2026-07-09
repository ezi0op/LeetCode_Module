class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int s=0;
		int e=numbers.length-1;
		while(s<e) {
			int t=numbers[s]+numbers[e];
			if(t==target) {
				return new int[] {s+1,e+1};
			}
			if(t<target) {
				s++;
			}else {
				e--;
			}
		}
		return new int[] {-1,-1};
    }
}
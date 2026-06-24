class Solution {
    public double average(int[] salary) {
     Arrays.sort(salary);
		int s = 1;
		int e = salary.length - 2;
		int index = 0;
		int[] ans = new int[salary.length - 2];

		while (s <= e) {

			ans[index++] = salary[s];
			s++;

		}
		return Arrays.stream(ans).average().orElse(0.0);

    }
}
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
			StringBuilder sb = new StringBuilder();
			// traverse string in chunks of size k
			for (int i = 0; i < s.length(); i += k) {

				int sum = 0;
				// calculate the sum of digits in the current chunk
				// we are setting min to avoid index out of bounds exception
				for (int j = i; j < Math.min(i + k, s.length()); j++) {
					sum += s.charAt(j) - '0';
				}
				sb.append(sum);

			}
			s = sb.toString();

		}
		return s;

    }
}
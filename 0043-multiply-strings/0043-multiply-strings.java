class Solution {
    public String multiply(String a, String b) {
        

		if (a.equals("0") || b.equals("0")) {
			return "0";
		}

		int m = a.length();
		int n = b.length();

		int[] result = new int[m + n];
		for (int i = m; i > 0; i--) {
			for (int j = n; j > 0; j--) {
				int mul = (a.charAt(i - 1) - '0') * (b.charAt(j - 1) - '0');
				int sum = mul + result[i + j-1];
				result[i + j-1] = sum % 10;
				result[i + j -2] += sum / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int dig : result) {
			if (sb.length() > 0 || dig != 0) {
				sb.append(dig);
			}
		}

		return sb.toString();
    }
}
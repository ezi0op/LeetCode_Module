class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            // here we are taking the minimum of 9 and sum because we can only take a
            // maximum of 9 in each digit
            int dig = Math.min(9, sum);

            sb.append(dig);
            // remove dig from sum because we have already added it to the string builder
            sum -= dig;
        }
        return sum == 0 ? sb.toString() : "";
    }
}
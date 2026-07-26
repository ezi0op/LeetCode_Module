class Solution {


   static int[][] dp;

    public int uniquePaths(int r, int c) {
	 dp = new int[r + 1][c + 1];
		return solve(r,c);

	}
    static int solve(int r,int c){
        if(r==1||c==1){
            return 1;
        }
    if(dp[r][c]!=0){
        return dp[r][c];
    }

        return dp[r][c]=solve(r-1,c)+solve(r,c-1);
    }

}
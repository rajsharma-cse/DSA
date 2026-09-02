class Solution {
    int[][] dp;
    public int fun(int i,int j,int m,int n){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i==m || j==n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int right=fun(i,j+1,m,n);
        int down=fun(i+1,j,m,n);
        return dp[i][j] =right+down;
    }
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        // for(int row[]:dp) Arrays.fill(row,-1);
        // return fun(0,0,m,n);

        dp[m-1][n]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
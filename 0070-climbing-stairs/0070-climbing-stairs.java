class Solution {
    int[] dp;
    public int fun(int n){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int one=fun(n-1);
        int two=fun(n-2);
        return dp[n]=one+two;
    }
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return fun(n);
    }
}
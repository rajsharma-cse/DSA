class Solution {
    public int fun(int[] cost,int i){
        if(i<0){
            return 0;
        }
        return cost[i]+Math.min(fun(cost,i-1),fun(cost,i-2));
    }
    public int tab(int[] arr){
        int n=arr.length;
        int[] dp=new int[n+1];
        dp[0]=arr[0];
        dp[1]=arr[1];
        for(int i=2;i<n;i++){
            dp[i]=arr[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        // return Math.min(fun(cost,n-1),fun(cost,n-2));
        return tab(cost);
    }
}
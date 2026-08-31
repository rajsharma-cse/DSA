class Solution {
    int[] dp;
    public int fun(int[] arr,int i){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int rob=arr[i]+fun(arr,i+2);
        int notrob=fun(arr,i+1);
        return dp[i]=Math.max(rob,notrob);
    }
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return fun(nums,0);
    }
}
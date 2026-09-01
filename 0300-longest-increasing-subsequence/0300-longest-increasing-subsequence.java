class Solution {
    int[][] dp;
    public int fun(int[] arr,int i,int prev ){
        if(i==arr.length){
            return 0;
        }
        if( dp[i][prev+1]!=-1) return dp[i][prev+1];
        if(prev == -1 || arr[i]>arr[prev]){
            int pick=1+fun(arr,i+1,i);
            int notpick=fun(arr,i+1,prev);
            return dp[i][prev+1]= Math.max(pick,notpick);
        }else return dp[i][prev+1]=fun(arr,i+1,prev);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n+1][n+1];
        for(int[] r:dp) Arrays.fill(r,-1);
        return fun(nums,0,-1);
    }
}
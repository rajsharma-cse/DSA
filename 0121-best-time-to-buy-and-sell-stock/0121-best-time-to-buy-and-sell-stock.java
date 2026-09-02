class Solution {
    int[][] dp;
    public int fun(int[] arr, int i,int k){
        if(i==arr.length) return 0;
        if(dp[i][k]!=-1) return dp[i][k];
        if(k==0) return 0;
        if(k==2){ //buy
            int buy=fun(arr,i+1,k-1)-arr[i];
            int nobuy=fun(arr,i+1,k);
            return dp[i][k]=Math.max(buy,nobuy);
        }   
        else{ //sell
            int sell=fun(arr,i+1,k-1)+arr[i];
            int nosell=fun(arr,i+1,k);
            return dp[i][k]=Math.max(sell,nosell);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n+1][3];
        for(int row[]:dp) Arrays.fill(row,-1);
        return fun(prices,0,2);
    }
}
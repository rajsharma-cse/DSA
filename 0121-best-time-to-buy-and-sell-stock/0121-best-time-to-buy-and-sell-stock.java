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
    public int maxProfit(int[] arr) {
        int n=arr.length;
        dp=new int[n+1][3];
        // for(int row[]:dp) Arrays.fill(row,-1);

        for(int i=n-1;i>=0;i--){
            for(int j=2;j>=0;j--){
                if(j==2){
                    int buy=dp[i+1][j-1]-arr[i];
                    int nobuy=dp[i+1][j];
                    dp[i][j]=Math.max(buy,nobuy);
                }else if(j==1){
                    int sell=dp[i+1][j-1]+arr[i];
                    int nosell=dp[i+1][j];
                    dp[i][j]=Math.max(sell,nosell);
                }
            }
        }
        return dp[0][2];

        // return fun(arr,0,2);
    }
}
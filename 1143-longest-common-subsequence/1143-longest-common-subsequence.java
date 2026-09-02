class Solution {
    int[][] dp;
    public int memo(String s1,String s2,int i,int j){
        int n=s1.length();
        int m=s2.length();
        if(i==n || j==m){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j]=1+memo(s1,s2,i+1,j+1);
        }
        int a=memo(s1,s2,i+1,j);
        int b=memo(s1,s2,i,j+1);
        return dp[i][j]=Math.max(a,b);
        
    }
    public int tab(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        Arrays.fill(dp[n],0);
        for(int i=0;i<=n;i++){
            dp[i][m]=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j]=1+dp[i+1][j+1];
                else{
                    int a=dp[i][j+1];
                    int b=dp[i+1][j];
                    dp[i][j]=Math.max(a,b);
                }
            }
        }
        return dp[0][0];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n+1][m+1];
        // for(int[] row:dp) Arrays.fill(row,-1);
        return tab(text1,text2);
    }
}
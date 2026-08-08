class Solution {
    int[][] dp;
    public int fun(String s1,String s2,int i,int j){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j]= 1+fun(s1,s2,i-1,j-1);
            return dp[i][j];
        } 
        int x= fun(s1,s2,i-1,j);
        int y=fun(s1,s2,i,j-1);
        dp[i][j]= Math.max(x,y);
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return fun(text1,text2,text1.length()-1,text2.length()-1);
    }
}
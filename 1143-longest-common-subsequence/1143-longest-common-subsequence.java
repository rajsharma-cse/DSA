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
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n+1][m+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return memo(text1,text2,0,0);
    }
}
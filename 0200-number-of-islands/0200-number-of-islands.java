class Solution {
    public boolean isSafe(int i,int j,int n,int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public void dfs(int i,int j,int n,int m,char[][] grid,boolean[][] vis){
        vis[i][j]=true;
        if(isSafe(i+1,j,n,m) && grid[i+1][j]=='1' && !vis[i+1][j])
            dfs(i+1,j,n,m,grid,vis);

        if(isSafe(i,j+1,n,m) && grid[i][j+1]=='1' && !vis[i][j+1])
            dfs(i,j+1,n,m,grid,vis);

        if(isSafe(i-1,j,n,m) && grid[i-1][j]=='1' && !vis[i-1][j])
            dfs(i-1,j,n,m,grid,vis);

        if(isSafe(i,j-1,n,m) && grid[i][j-1]=='1' && !vis[i][j-1])
            dfs(i,j-1,n,m,grid,vis);
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] vis=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    ans++;
                    dfs(i,j,n,m,grid,vis);
                }
            }
        }
        return ans;
    }
}
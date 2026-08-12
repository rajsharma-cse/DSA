class Solution {
    int[] x={-1,1,0,0};
    int[] y={0,0,-1,1};
    public boolean isSafe(int i,int j,int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public void dfs(char[][] grid,int i,int j,int n,int m,boolean[][] vis){
        vis[i][j]=true;
        for(int k=0;k<4;k++){
            int row=i+x[k];
            int col=j+y[k];
            if(isSafe(row,col,n,m) && grid[row][col] == '1' && !vis[row][col]){
                dfs(grid,row,col,n,m,vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid,i,j,n,m,vis);
                    res++;
                }
            }
        }
        return res;
    }
}
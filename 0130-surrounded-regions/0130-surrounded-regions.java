class Solution {
    public boolean isSafe(int i,int j,int n,int m){
        return i>=0 &&j>=0 && i<n && j<m;
    }
    int[] x={1,-1,0,0};
    int[] y={0,0,1,-1};
    public void dfs(char[][] board,int i,int j,int n,int m){
        board[i][j]='#';
        for(int k=0;k<4;k++){
            int row=i+x[k];
            int col=j+y[k];
            if(isSafe(row,col,n,m) && board[row][col]=='O') 
                dfs(board,row,col,n,m);
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<m;i++){
            if(board[0][i] == 'O') dfs(board,0,i,n,m);
            if(board[n-1][i] == 'O') dfs(board,n-1,i,n,m);
        }
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O') dfs(board,i,0,n,m);
            if(board[i][m-1] == 'O') dfs(board,i,m-1,n,m);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == '#') board[i][j]='O';
                else board[i][j] = 'X';
            }
        }
    }
}
class Solution {
    class Pair<U,V>{
        U x;
        V y;
        public Pair(U x,V y){
            this.x=x;
            this.y=y;
        }
        public U getX(){
            return x;
        }
        public V getY(){
            return y;
        }
    }
    public boolean isSafe(int x,int y,int n,int m){
        return x>=0 && y>=0 && x<n && y<m;
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair<Integer,Integer>> q=new ArrayDeque<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    grid[i][j] =-1;
                    q.offer(new Pair(i,j));
                }
                if(grid[i][j] == 1) fresh++;
            }
        }

        int[] xAxis={-1,1,0,0};
        int[] yAxis={0,0,-1,1};

        int time=0;
        while(!q.isEmpty() && fresh>0){
            time++;
            int s=q.size();
            while(s-- > 0){
                Pair<Integer,Integer> cor=q.poll();
                int row=cor.getX();
                int col=cor.getY();
                for(int i=0;i<4;i++){
                    int x=row + xAxis[i];
                    int y=col + yAxis[i];
                    if(isSafe(x,y,n,m) && grid[x][y] == 1){
                        grid[x][y] = -1;
                        q.offer(new Pair(x,y));
                        fresh--;
                    }
                }
            }
        }
        if(fresh>0) return -1;
        return time;
    }
}
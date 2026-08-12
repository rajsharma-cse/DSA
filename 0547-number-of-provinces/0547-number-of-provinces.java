class Solution {
    public void dfs(List<List<Integer>> adj, boolean[] vis,int i){
        vis[i]=true;
        for(int neigh:adj.get(i)){
            if(!vis[neigh]){
                dfs(adj,vis,neigh);
                vis[neigh]=true;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int ans=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj,vis,i);
                ans++;
            }
        }
        return ans;
    }
}
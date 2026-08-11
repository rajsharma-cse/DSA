class Solution {
    boolean[] safe;
    public boolean isSafe(int[][] adj, int i,boolean[] vis,boolean[] safe){
        vis[i]=true;;
        boolean res=true;
        for(int j=0;j<adj[i].length;j++){
            int neigh=adj[i][j];
            if(vis[neigh] == false) isSafe(adj,neigh,vis,safe);
            if(safe[neigh] == false){
                res=false;
                break;
            }
        }
        return safe[i]=res;
        // return safe[i]>0;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        int n=graph.length;
        // safe=new boolean[n];
        boolean[] safe=new boolean[n];
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(graph[i].length==0) safe[i]=true;;
        }
        for(int i=0;i<n;i++){
            if(isSafe(graph,i,vis,safe)) ans.add(i);            
        }
        return ans;
    }
}
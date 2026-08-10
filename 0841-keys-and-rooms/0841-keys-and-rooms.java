class Solution {
    public void dfs(List<List<Integer>> rooms,boolean[] vis,int i){
        vis[i]=true;
        for(int j=0;j<rooms.get(i).size();j++){
            int neb=rooms.get(i).get(j);
            if(!vis[neb])
                dfs(rooms,vis,neb);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        dfs(rooms,vis,0);
        for(boolean ele:vis){
            if(!ele) return false;
        }
        return true;
    }
}
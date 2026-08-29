class Pair{
    int node;
    int dist;
    public Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int dijkstra(ArrayList<ArrayList<Pair>> adj,int src,int n){     
        ArrayList<Integer> distance=new ArrayList<>(Collections.nCopies(n+1,Integer.MAX_VALUE));
        distance.set(src,0);
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist - b.dist);
        pq.offer(new Pair(src,0));
        
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            int d=p.dist;
            if(d > distance.get(node)) continue;
            for(Pair pair:adj.get(node)){
                int neigh=pair.node;
                int wt=pair.dist;
                if(d+wt < distance.get(neigh)){
                    distance.set(neigh,wt+d);
                    pq.offer(new Pair(neigh,d+wt));
                }
            }
            
        }
        int max=0;
        for (int i = 1; i <= n; i++) {
            if (distance.get(i) == Integer.MAX_VALUE) return -1;
            max=Math.max(max,distance.get(i));
        }
        return max;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        
        for(int i=0;i<times.length;i++){
            int a=times[i][0];
            int b=times[i][1];
            int w=times[i][2];
            
            adj.get(a).add(new Pair(b,w));
            
        }
        return dijkstra(adj,k,n);
    }
}
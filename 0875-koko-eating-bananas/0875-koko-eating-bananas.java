class Solution {
    public boolean fun(int k,int[] piles, int h){
        int x=0;
        for(int ele:piles){
            x+=Math.ceil((double)ele/k);
        }
        return x<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int ele:piles){
            high=Math.max(high,ele);
        }
        int ans=0;
        while(low <= high){
            int k=low+(high-low)/2;
            if(fun(k,piles,h)){
                ans=k;
                high=k-1;
            }else{
                low=k+1;
            }
        }
        return ans;
    }
}
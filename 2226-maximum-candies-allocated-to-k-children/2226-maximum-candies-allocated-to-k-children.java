class Solution {
    public boolean possible(int[] arr,long k,long mid){
        long count=0;
        for(int ele:arr){
            if(ele>=mid){
                count+=ele/mid;
            }
        }
        return count >= k;
    }
    public int maximumCandies(int[] arr, long k) {
        long low=1L,high=0;
        for(int ele:arr) high=Math.max(high,ele);
        long ans=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(possible(arr,k,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return (int)ans;
    }
}
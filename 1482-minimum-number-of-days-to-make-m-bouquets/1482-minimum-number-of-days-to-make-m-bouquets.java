class Solution {
    public boolean possible(int[] arr,int m, int k,int mid){
        int bk=0;
        int fl=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                fl++;
                if(fl==k){
                    bk++;
                    fl=0;
                } 
            }else{
                fl=0;
            }
        }
        return bk>=m;
        
    }
    public int minDays(int[] arr, int m, int k) {
        if(arr.length < m*k) return -1;
        int n=arr.length;
        int low=Integer.MAX_VALUE,high=0;
        for(int ele:arr) {
            high=Math.max(ele,high);
            low=Math.min(low,ele);
        }
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(arr,m,k,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
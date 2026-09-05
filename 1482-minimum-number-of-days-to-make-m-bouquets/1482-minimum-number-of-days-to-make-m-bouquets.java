class Solution {
    public boolean helper(int[] arr, int day,int m,int k){
        int bokey=0;
        int flw=0;
        for(int ele:arr){
            if(ele<=day){
                flw++;
                if(flw==k){
                    bokey++;
                    flw=0;
                }
            }else flw=0;
        }
        return bokey>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low=1,high=0;
        for(int ele:bloomDay) high=Math.max(ele,high);

        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
}
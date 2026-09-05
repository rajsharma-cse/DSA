class Solution {
    public boolean helper(int[] arr,int mid,int k){//guess sum
        int sp=1;
        int sum=0;
        for(int ele:arr){
            sum+=ele;
            if(sum>mid){
                sp++;
                sum=ele;
            }
        }
        return sp<= k;
    }
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE,high=0;
        for(int ele:nums){
            low=Math.max(low,ele);
            high+=ele;
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(nums,mid,k)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
}
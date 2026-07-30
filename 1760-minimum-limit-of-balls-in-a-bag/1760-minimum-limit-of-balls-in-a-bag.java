class Solution {
    public boolean possible(int[] arr,int max,int splt){
        long count=0;
        for(int i=0;i<arr.length;i++){
            // if(arr[i]>=splt){
                count+=arr[i]/splt;
                if(arr[i]% splt == 0) count--;
            // }
        }
        return count<=max;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int n=nums.length;
        int low=1,high=Integer.MIN_VALUE;
        for(int ele:nums) high=Math.max(ele,high);
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(nums,maxOperations,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
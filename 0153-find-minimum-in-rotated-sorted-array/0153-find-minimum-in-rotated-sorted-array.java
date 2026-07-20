class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0,high=n-1;
        int ans=nums[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid] <= nums[n-1]){
                ans=nums[mid];
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
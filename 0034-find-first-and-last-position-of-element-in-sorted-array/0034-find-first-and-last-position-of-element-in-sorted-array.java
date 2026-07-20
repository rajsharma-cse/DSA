class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int f=-1;
        int l=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid] == target){
                f=mid;
                high=mid-1;
            }else if(nums[mid] < target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        low=0;high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid] == target){
                l=mid;
                low=mid+1;
            }else if(nums[mid] < target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return new int[]{f,l};
    }
}
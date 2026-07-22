class Solution {
    public int search(int[] nums, int target) {
        // if(arr.length ==1){
        //     if(arr[0] == target) return 0;
        // }
        int n=nums.length;
        int low=0,high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid] <= nums[n-1]){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        if(ans-1 >=0 && nums[0] <= target && nums[ans-1] >= target){
            low=0; high=ans-1;
        }else{
            low=ans; high=n-1;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return -1;
    }
}
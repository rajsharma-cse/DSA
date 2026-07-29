class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n=arr.length;
        int low=0,high=n-1;
        int idx=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid][0] <= target){
                idx=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        low=0; high=arr[0].length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[idx][mid] == target) return true;
            else if(arr[idx][mid] < target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
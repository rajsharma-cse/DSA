class Solution {
    public int search(int[] arr, int target) {
        int n=arr.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[0]<=arr[mid]){
                if(arr[mid] == target) return mid;
                else if(arr[mid] < target) low=mid+1;
                else{
                    if(arr[0] <= target) high=mid-1;
                    else low=mid+1;
                }
            }else{
                if(arr[mid] == target) return mid;
                else if(arr[mid]>target) high=mid-1;
                else{
                    if (arr[n-1] >= target ) low=mid+1;
                    else high=mid-1;
                }
            }
        }
        return -1;
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0,high=matrix.length-1;
        int n=matrix[0].length;

        while(low <= high){
            int mid=low+(high-low)/2;
            if(matrix[mid][0]<=target && matrix[mid][n-1]>=target){
                int low1=0,high1=n-1;
                while(low1<=high1){
                    int mid1=low1+(high1-low1)/2;
                    if(matrix[mid][mid1] == target) return true;
                    else if(matrix[mid][mid1] < target) low1=mid1+1;
                    else high1=mid1-1;
                }
                return false;
            }else if(matrix[mid][0]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}
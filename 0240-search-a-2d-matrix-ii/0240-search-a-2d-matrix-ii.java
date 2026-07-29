class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n=arr.length;
        int m=arr[0].length;

        int row=n-1;
        int col=0;
        while(row>=0 && col<m){
            if(arr[row][col] == target) return true;
            else if(arr[row][col] < target) col++;
            else row--;
        }
        return false;
    }
}
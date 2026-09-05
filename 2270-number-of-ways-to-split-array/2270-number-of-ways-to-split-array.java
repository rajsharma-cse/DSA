class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalsum=0;
        for(int ele:nums) totalsum+=ele;

        long cursum=0;
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            cursum+=nums[i];
            long right=totalsum-cursum;
            if(cursum >= right) ans++;
        }
        return ans;
    }
}
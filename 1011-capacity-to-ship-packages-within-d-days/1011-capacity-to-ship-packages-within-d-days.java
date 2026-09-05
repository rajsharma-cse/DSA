class Solution {
    public boolean helper(int[] arr,int cap,int day){
        int d=1;
        int sum=0;
        for(int ele:arr){
            sum+=ele;
            if(sum>cap){
                d++;
                sum=ele;
            }
        }
        return d<=day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int ele:weights){
            high+=ele;
            low=Math.max(low,ele);
        } 
        int ans=0;
        while(low<=high){
            int cap=low+(high-low)/2;
            if(helper(weights,cap,days)){
                ans=cap;
                high=cap-1;
            }else{
                low=cap+1;
            }

        }
        return ans;
    }
}
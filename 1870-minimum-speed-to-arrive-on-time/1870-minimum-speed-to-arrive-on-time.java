class Solution {
    public boolean possible(int[] arr, double hour,int mid){
        double count=0;
        for(int i=0;i<arr.length;i++){
            int ele=arr[i];
            if(i==arr.length-1){
                count+=((double)ele/mid);
            }else{
                count+=Math.ceil((double)ele/mid);
            }
        }
        return count<=hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int low=1,high=(int)10e7;
        

        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(dist,hour,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
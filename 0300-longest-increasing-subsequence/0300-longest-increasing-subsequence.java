class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        List<Integer> temp=new ArrayList<>();
        temp.add(arr[0]);
        for(int i=1;i<n;i++){
            if(temp.get(temp.size()-1)<arr[i]){
                temp.add(arr[i]);
            }else{
                int low=0;
                int high=temp.size();
                int ans=0;
                while(low<high){
                    int mid=low+(high-low)/2;
                    if(temp.get(mid) >= arr[i]){
                        ans=mid;
                        high=mid;
                    }else{
                        low=mid+1;
                    }
                }
                temp.set(ans,arr[i]);
            }
        }
        return temp.size();
    }
}
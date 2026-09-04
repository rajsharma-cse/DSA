class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0;
        long sum=0,ans=0;
        while(j<n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            sum+=arr[j];
            if(j-i+1 == k){
                
                if(map.size() == k){
                    ans=Math.max(ans,sum);
                }
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i]) == 0) map.remove(arr[i]);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return ans;
    }
}
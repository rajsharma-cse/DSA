class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i]%2;
        }
        int[] prefix=new int[n+1];
        for(int i=1;i<=n;i++) prefix[i]=prefix[i-1]+arr[i-1];
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int i=1;i<=n;i++){
        
            int sp=prefix[i]-k;
            int feq=map.getOrDefault(sp,0);
            count+=feq;
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return count;
    }
}
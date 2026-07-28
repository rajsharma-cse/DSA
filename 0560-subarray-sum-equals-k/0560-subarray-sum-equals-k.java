class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        int[] prefix=new int[n+1];
        for(int i=1;i<=n;i++) prefix[i]=prefix[i-1]+nums[i-1];

        int count=0;
        for(int i=1;i<=n;i++){
            int pl=prefix[i]-k;
            int feq=map.getOrDefault(pl,0);
            count+=feq;
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return count;
    }
}
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int x=sum%k;
            if(x<0) x+=k;
            if(map.containsKey(x)){
                ans+=map.get(x);
            }
            map.put(x,map.getOrDefault(x,0)+1);
        }
        return ans;
    }
}
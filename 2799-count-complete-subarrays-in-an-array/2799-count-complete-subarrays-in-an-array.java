class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:nums) map.put(ele,map.getOrDefault(ele,0)+1);

        int x=map.size();
        map.clear();
        int ans=0;
        int i=0,j=0,n=nums.length;
        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size()==x){
                ans+=n-j;
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            // ans++;
            // if(map.size()==x) ans++;
            j++;
        }
        return ans;
    }
}
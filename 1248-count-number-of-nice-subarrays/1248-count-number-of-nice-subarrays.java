class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i]%2;
        }

        int[] prefix=new int[n+1];
        int sum=0;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int sp=sum-k;
            int feq=map.getOrDefault(sp,0);
            count+=feq;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
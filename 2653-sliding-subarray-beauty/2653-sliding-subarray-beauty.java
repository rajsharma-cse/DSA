class Solution {
    public int[] getSubarrayBeauty(int[] arr, int k, int x) {
        int n=arr.length;
        int[] ans=new int[n-k+1];

        TreeMap<Integer,Integer> map=new TreeMap<>();
        int i=0,j=0;
        while(j<n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            if(j-i+1 == k){
                int small=0;
                int freq=0;
                for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                    freq+=entry.getValue();
                    if(freq>=x){
                        small=entry.getKey();
                        break;
                    }
                }
                if (small < 0) {
                    ans[i] = small;
                } else {
                    ans[i] = 0;
                }
                map.put(arr[i],map.get(arr[i])-1);

                if(map.get(arr[i]) == 0) map.remove(arr[i]);
                i++;
            }
            j++;
        }
        return ans;
    }
}
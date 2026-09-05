class Solution {
    public int totalFruit(int[] arr) {
        // if(arr.length == 1) return arr[0];
        int i=0,j=0;
        int n=arr.length;
        // int curF=0;
        int maxF=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        while(j<n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            // curF+=arr[j];
            while(map.size() > 2){
                map.put(arr[i],map.get(arr[i])-1);
                // curF-=arr[i]; 
                if(map.get(arr[i]) == 0) map.remove(arr[i]);
                i++;
            }
            // if(map.size()==2)
                maxF=Math.max(maxF,j-i+1);
            j++;
        }
        return maxF;

    }
}
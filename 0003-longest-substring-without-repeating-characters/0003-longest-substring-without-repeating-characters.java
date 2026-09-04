class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        
        int i=0,j=0,len=0;
        while(j<n){
            char c=s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.get(c)>1){
                char cc=s.charAt(i);
                map.put(cc,map.get(cc)-1);
                if(map.get(cc)==0) map.remove(cc);
                i++;
            }
            len=Math.max(len,j-i+1);
            j++;

        }
        return len;
    }
}
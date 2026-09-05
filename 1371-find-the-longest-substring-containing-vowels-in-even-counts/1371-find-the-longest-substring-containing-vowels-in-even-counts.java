class Solution {
    public int findTheLongestSubstring(String s) {
        int mask=0;
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='a') mask ^=(1<<0);
            else if(c=='e') mask ^=(1<<1);
            else if(c=='i') mask ^=(1<<2);
            else if(c=='o')mask ^=(1<<3);
            else if(c=='u')mask ^=(1<<4);
            if(map.containsKey(mask)) ans=Math.max(ans,i-map.get(mask));

            if(!map.containsKey(mask)) map.put(mask,i);
        }
        return ans;
    }
}
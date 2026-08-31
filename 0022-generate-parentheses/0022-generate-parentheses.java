class Solution {
    public void fun(List<String> res,int open, int close,int n,String s){
        if(open==n && close == n){
            res.add(s);
            return;
        }
        if(open<n){
            fun(res,open+1,close,n,s+'(');
        }
        if(open>close){
            fun(res,open,close+1,n,s+')');
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> cur=new ArrayList<>();
        fun(cur,0,0,n,"");
        return cur;
    }
}
class Solution {
    ArrayList<Integer> arr=new ArrayList<>(Collections.nCopies(10000,-1));
    public int fun(int n){
        if(n==0 || n==1){
            return 1;
        }else if(n<0){
            return 0;
        }
        if(arr.get(n)!=-1) return arr.get(n);
        arr.set(n,fun(n-1)+fun(n-2));
        return arr.get(n);
    }
    public int climbStairs(int n) {
        return fun(n);
    }
}
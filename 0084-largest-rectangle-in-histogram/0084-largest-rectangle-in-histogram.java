class Solution {
    public int largestRectangleArea(int[] h) {
        int n=h.length;
        int[] next=new int[n];
        Stack<Integer> stk=new Stack<>();
        next[n-1]=n;
        stk.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!stk.isEmpty() && h[stk.peek()] >= h[i]) stk.pop();
            next[i]=stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        stk.clear();
        stk.push(0);
        int[] prev=new int[n];
        prev[0]=-1;
        for(int i=1;i<n;i++){
            while(!stk.isEmpty() && h[stk.peek()] >= h[i]) stk.pop();
            prev[i]=stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,h[i]*(next[i]-prev[i]-1));
        }
        return ans;

    }
}
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq=new ArrayDeque<>();

        int n=arr.length;
        int[] ans=new int[n-k+1];
        int i=0,j=0;
        while(j<n){
            while(!dq.isEmpty() && arr[j]>dq.peekLast()) dq.pollLast();

            dq.offerLast(arr[j]);
            if(j-i+1 == k){
                ans[i]=dq.peekFirst();
                if(!dq.isEmpty() && arr[i]==dq.peekFirst()) dq.pollFirst();
                i++;
            }
            j++;

        }
        return ans;
    }
}
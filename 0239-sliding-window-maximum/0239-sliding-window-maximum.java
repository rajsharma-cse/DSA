class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int i=0,j=0;
        int n=arr.length;

        int[] ans=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>(); //max heap

        while(j<n){
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[j]) dq.pollLast();
            dq.offerLast(j);

            if(j-i+1 == k){
                ans[i]=arr[dq.peekFirst()];
                if(dq.peekFirst() == i) dq.pollFirst();
                i++;
            }
            j++;
        }
        return ans;
    }
}
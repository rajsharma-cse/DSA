class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int ans[]=new int[arr.length-k+1];
        int i=0,j=0;
        while(j<arr.length){
            while(!dq.isEmpty() && arr[j]>arr[dq.peekLast()]) dq.pollLast();
            dq.offerLast(j);
            if(j-i+1 == k){
                ans[i]=arr[dq.peekFirst()];
                if(arr[dq.peekFirst()] == arr[i]) dq.pollFirst();
                i++;
            }
            j++;
        }
        return ans;
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<k;i++){
            pq.offer(nums[i]);
        }
        for(int i=k;i<n;i++){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        // for(int i=0;i<k-1)
        return pq.peek();
    }
}
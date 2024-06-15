class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k == 0 || k > nums.length || nums.length == 0)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< k;i++)
            pq.add(nums[i]);
        for(int i = k;i<nums.length;i++)
        {
            if(nums[i] > pq.peek())
            {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
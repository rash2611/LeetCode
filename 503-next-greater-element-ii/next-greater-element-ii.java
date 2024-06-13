class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2 * nums.length - 1; i>=0;i--)
        {
            while(!stack.isEmpty() && nums[i% nums.length] >= stack.peek())
            {
                stack.pop();
            }
            if(i < nums.length)
            {
                if(!stack.isEmpty())
                {
                    res[i] = stack.peek();
                }
                else
                    res[i] = -1;
            }
            stack.push(nums[i % nums.length]);
        }
        return res;
    }
}
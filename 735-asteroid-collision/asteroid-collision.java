class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< asteroids.length;i++)
        {
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0)
            {
                int sum = stack.peek() + asteroids[i];
                if(sum == 0)
                {
                    stack.pop();
                    destroyed = true;
                    break;
                }
                else if(sum < 0)
                {
                    stack.pop();
                }
                else
                {
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed)
                stack.push(asteroids[i]);
        }
        int ans[] = new int[stack.size()];
        for(int i = ans.length-1;i>=0;i--)
        {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
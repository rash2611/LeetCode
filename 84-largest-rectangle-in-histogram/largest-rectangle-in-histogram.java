class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int leftSmaller[] = new int[n];
        int rightSmaller[] = new int[n];
        int maxArea = 0;
        for(int i = 0;i<n;i++)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.isEmpty())
                leftSmaller[i] = 0;
            else
                leftSmaller[i] = stack.peek() + 1;
            stack.push(i);
        }

        while(!stack.isEmpty())
            stack.pop();
        for(int i = n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                stack.pop();
            if(stack.isEmpty())
                rightSmaller[i] = n - 1;
            else
                rightSmaller[i] = stack.peek() - 1;
            maxArea = Math.max(maxArea, heights[i] * (rightSmaller[i] - leftSmaller[i] + 1));
            stack.push(i);
        }
        return maxArea;
    }
}
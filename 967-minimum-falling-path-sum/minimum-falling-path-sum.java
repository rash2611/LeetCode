class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int front[] = new int[n];
        int minSum = Integer.MAX_VALUE;
        for(int i = n-1;i>=0;i--)
        {
            int curr[] = new int[n];
            for(int j = n-1;j>=0;j--)
            {
                if(i == n-1)
                {
                    curr[j] = matrix[i][j];
                }
                else{
                    int down = front[j];
                    int leftDiagonal = Integer.MAX_VALUE;
                    int rightDiagonal = Integer.MAX_VALUE;
                    if(j>0)
                        leftDiagonal = front[j-1];
                    if(j<n-1)
                        rightDiagonal = front[j+1];
                    curr[j] = matrix[i][j] +  Math.min(down, Math.min(leftDiagonal,rightDiagonal));
                    
                }
                if(i == 0)
                    minSum = Math.min(minSum, curr[j]);
            }
            front = curr;
        }
        return minSum;
    }
}
import java.util.*;
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int prev[] = new int[n];
        for(int i = 0;i<m;i++)
        {
            int temp[] = new int[n];
            for(int j = 0;j<n;j++)
            {
                if(i == 0 && j == 0)
                    temp[j] = grid[i][j];
                else if(i == 0)
                    temp[j] = grid[i][j] + temp[j-1];
                else if(j == 0)
                    temp[j] = grid[i][j] + prev[j];
                else
                {
                    int up = prev[j];
                    int left = temp[j-1];
                    temp[j] = grid[i][j] + Math.min(left,up);
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
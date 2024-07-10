class Solution {
    public void reverse(int[] matrix, int low, int high)
    {
        while(low<=high)
        {
            int temp = matrix[low];
            matrix[low] = matrix[high];
            matrix[high] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<= n-2;i++)
        {
            for(int j = i+1;j<n;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0;i<n;i++)
        {
            reverse(matrix[i],0,n-1);
        }
    }
}
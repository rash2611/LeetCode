class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0)
             return false;
        int column = matrix[0].length;
        int start = 0;
        int end = row * column - 1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(matrix[mid/column][mid%column] < target)
            {
                start = mid+1;
            }
            else if(matrix[mid/column][mid%column] >target)
            {
                end = mid - 1;
            }
            else
                return true;
             
        }
        return false;
        
    }
}
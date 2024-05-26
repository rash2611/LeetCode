class Solution {
    public boolean isValid(char c, int row, int col, char[][] grid)
	{
		for(int i = 0;i<9;i++)
		{
			if(grid[row][i] == c)
				return false;
			if(grid[i][col] == c)
				return false;
			if(grid[row/3 * 3 + (i/3)][col/3 * 3 + (i%3)] == c)
				return false;
		}
		return true;
	}
	public boolean solve(char[][] grid){
		for(int i = 0;i<grid.length;i++)
		{
			for(int j = 0;j<grid[0].length;j++)
			{
				if(grid[i][j] == '.')
				{
					for(char c = '1'; c <= '9';c++)
					{
						if(isValid(c,i,j,grid))
						{
							grid[i][j] = c;
							if(solve(grid))
                                return true;
                            else
							    grid[i][j] = '.';
						}
					}
					return false;
				}
			}
        }
        return true;
	}
	public void solveSudoku(char[][] board){
		solve(board);
	}

}
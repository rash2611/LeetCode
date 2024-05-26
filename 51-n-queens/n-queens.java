class Solution {
 public boolean validate(int row, int col, char[][] board){
	int drow = row;
	int dcol = col;
    while(drow>= 0 && dcol>=0)
	{
		if(board[drow][dcol] == 'Q')
			return false;
        drow--;
        dcol--;
        }
    dcol = col;
    while(dcol >= 0)
        {
            if(board[row][dcol] == 'Q')
                return false;
            dcol--;
        }
        drow = row;
        dcol = col;
        while(drow < board.length && dcol>= 0)
        {
            if(board[drow][dcol] == 'Q')
                return false;
            drow++;
            dcol--;
        }
        return true;
        }

public List<String> construct(char[][] board){
	List<String> ans = new ArrayList<>();
	for(int i = 0;i<board.length;i++){
		String s = new String(board[i]);
		ans.add(s);
	}
	return ans;
}
	public void solve(int col,char[][] board, List<List<String>> res){
		if(col == board.length)
		{
			res.add(construct(board));
			return;
		}
		for(int row = 0;row<board.length;row++)
		{
			if(validate(row,col, board))
			{
				board[row][col] = 'Q';
				solve(col+1,board,res);
				board[row][col] = '.';
			}
		}
}
	public List<List<String>> solveNQueens(int n){
		List<List<String>> res = new ArrayList<>();
		char[][] board = new char[n][n];
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
			{
				board[i][j] = '.';
			}
		}
		solve(0, board, res);
		return res;
	}

}
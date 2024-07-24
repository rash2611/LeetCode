class Solution {
    public boolean wordSearch(char[][] board, String word, int row, int col, int[][] visited, int index, int[] drow, int[] dcol, int m, int n)
    {
        if(index == word.length())
            return true;
        if(row < 0 || row >= m || col < 0 || col >= n || word.charAt(index) != board[row][col] || visited[row][col] == 1)
            return false;
        visited[row][col] = 1;
        for(int i = 0;i<4;i++)
        {
            int nrow = drow[i] + row;
            int ncol = dcol[i] + col;
            if(wordSearch(board,word,nrow,ncol,visited, index + 1, drow, dcol, m, n))
                return true;
        }
        visited[row][col] = 0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if(word.length() > (m*n))
            return false;
        int[][] visited = new int[m][n]; 
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(wordSearch(board,word,i,j,visited,0,drow,dcol,m,n))
                    return true;
            }
        }
        return false;
    }
}
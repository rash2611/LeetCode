class Solution {
    public void dfs(int[][] image, int sr, int sc, int[][] result, int color, int initialColor){
        int row = image.length;
        int column = image[0].length;
        result[sr][sc] = color;
        int deltarow[] = {-1,0,1,0};
        int deltacolumn[] = {0,1,0,-1};
        for(int i = 0;i<4;i++)
        {
            int nrow = sr + deltarow[i];
            int ncol = sc + deltacolumn[i];
            if(nrow>=0 && nrow< row && ncol>=0 && ncol<column && image[nrow][ncol] == initialColor && result[nrow][ncol]!= color)
            {
                dfs(image,nrow,ncol,result,color,initialColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int result[][] = image;
        int initialColor = image[sr][sc];
        dfs(image,sr,sc,result,color,initialColor);
        return result;
    }
}
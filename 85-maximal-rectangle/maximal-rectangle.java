class Solution {
    public int findMaxAreaHisto(int[] histo, int m)
    {
        int maxHistoArea = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<=m;i++)
        {
            while(!s.isEmpty() && (i == m || histo[s.peek()] > histo[i]))
            {
                int width = 0;
                int top = s.peek();
                s.pop();
                if(s.isEmpty())
                    width = i;
                else
                    width = i - s.peek() - 1;
                maxHistoArea = Math.max(maxHistoArea, (histo[top] * width));
            }
            s.push(i);
        }
        return maxHistoArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0)
            return 0;
        int m = matrix[0].length;
        if(m == 0)
            return 0;
        int maxArea = 0;
        int[] histo = new int[m];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(matrix[i][j] == '1')
                    histo[j]++;
                else
                    histo[j] = 0;
            }
            int area = findMaxAreaHisto(histo, m);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
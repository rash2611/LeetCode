class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int front[] = new int[n];
        for(int i = n-1;i>=0;i--)
        {
            for(int j = 0; j<=i;j++)
            {
                if(i == n-1)
                    front[j] = triangle.get(i).get(j);
                else
                    front[j] = triangle.get(i).get(j) + Math.min(front[j], front[j+1]);
            }
        }
        return front[0];
    }
}
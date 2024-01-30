class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int hash[] = new int[n];
        for(int i = 1;i<n;i++)
        {
            hash[i] = i;
            for(int prev = 0;prev < i;prev++)
            {
                if(nums[i]%nums[prev] == 0 && dp[i] < 1 + dp[prev])
                {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }
        int maxi = -1;
        int lastIndex = -1;
        for(int i = 0;i<n;i++)
        {
            if(dp[i]>maxi)
            {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex)
        {
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        Collections.reverse(list);
        return list;
    }
}
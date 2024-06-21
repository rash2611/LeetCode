class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i< nums.length;i++)
        {
            for(int j = i+1;j<nums.length;j++)
            {
                HashSet<Long> numSet = new HashSet<>();
                for(int k = j+1;k<nums.length;k++)
                {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;
                    if(numSet.contains(fourth))
                    {
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
                        list.sort(null);
                        set.add(list);
                    }
                    numSet.add((long)nums[k]);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();
        for(int i = 0;i<nums.length;i++)
        {
            Set<Integer> numSet = new HashSet<>();
            for(int j = i+1;j<nums.length;j++)
            {
                int thirdNum = -(nums[i] + nums[j]);
                if(numSet.contains(thirdNum))
                {
                    List<Integer> list = Arrays.asList(nums[i],nums[j],thirdNum);
                    list.sort(null);
                    resSet.add(list);
                }
                numSet.add(nums[j]);
            }
        }
        List<List<Integer>> res = new ArrayList<>(resSet);
        return res;
    }
}
class Solution {
    public void findPermute(int index, int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] hash)
    {
        if(index == nums.length)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length;i++)
        {
            if(!hash[i])
            {
                list.add(nums[i]);
                hash[i] = true;
                findPermute(index+1, nums,res,list,hash);
                list.remove(list.size() - 1);
                hash[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean hash[] = new boolean[nums.length];
        findPermute(0, nums, res,list,hash);
        return res;
    }
}
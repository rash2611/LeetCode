class Solution {
    public void findSubset(int[] nums, int index, List<List<Integer>> subset, List<Integer> list)
    {
       if(index == nums.length)
        {
            subset.add(new ArrayList<>(list));
            return;
        } 
        list.add(nums[index]);
        findSubset(nums, index+1, subset,list);
        list.remove(list.size() - 1);
        findSubset(nums, index+1,subset,list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findSubset(nums, 0, subset, list);
        return subset;
    }
}
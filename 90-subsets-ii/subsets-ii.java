class Solution {
    public void findSubsets(int index, int[] nums, List<Integer> list, List<List<Integer>> res){
	res.add(new ArrayList<>(list));

	for(int i = index; i<nums.length;i++)
	{
		if(i > index && nums[i] == nums[i-1])
			continue;
		list.add(nums[i]);
		findSubsets(i+1,nums,list,res);
		list.remove(list.size()-1);
	}
}
    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0,nums, list, res);
        return res;
        }

}
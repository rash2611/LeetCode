class Solution {
    	public void findPermute(int index, int[] nums, List<List<Integer>> res){
		if(index == nums.length){
			List<Integer> list = new ArrayList<>();
			for(int i = 0;i<nums.length;i++){
				list.add(nums[i]);
			}
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i = index; i<nums.length;i++){
			swap(index,i,nums);
			findPermute(index+1, nums, res);
			swap(index,i,nums);
}


	}
	public void swap(int index, int i, int[] nums){
		int temp = nums[index];
		nums[index] = nums[i];
		nums[i] = temp;
	}
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		findPermute(0, nums, res);
		return res;
	}

}
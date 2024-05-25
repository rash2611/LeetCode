class Solution {
    	public void findCombinations(int num, int length, int target, List<List<Integer>> res, List<Integer> list){
	if(list.size() == length && target == 0){
			res.add(new ArrayList<>(list));
            return;
	}
	if(num > 9)
        return;	

	list.add(num);
	findCombinations(num+1, length, target - num, res, list);
	list.remove(list.size()-1);
	findCombinations(num+1, length, target, res, list);

}
	public List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		findCombinations(1, k, n, res, list);
	return res;
}

}
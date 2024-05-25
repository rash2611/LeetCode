class Solution {
    public void findCombinations(int num, int length, int target, List<List<Integer>> res, List<Integer> list){
	if(list.size() == length && target == 0){
			res.add(new ArrayList<>(list));
            return;
	}

    for(int i = num;i<=9;i++)
    {
        if(i > target)
            break;
        list.add(i);
	    findCombinations(i+1, length, target - i, res, list);
	    list.remove(list.size()-1);
    }

}
	public List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		findCombinations(1, k, n, res, list);
	return res;
}

}
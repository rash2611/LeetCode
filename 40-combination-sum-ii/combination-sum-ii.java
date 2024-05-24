class Solution {
    public static void findUniqueSubsequence(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> res){
	if(target == 0)
	{
		res.add(new ArrayList<>(list));
		return;
	}
	for(int i = index;i < candidates.length;i++){
		if(i> index && candidates[i] == candidates[i-1])
			continue;
		if(candidates[i] > target)
			break;
		list.add(candidates[i]);
		findUniqueSubsequence(candidates, i+1, target - candidates[i], list, res);
		list.remove(list.size()-1);
	}
}

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		findUniqueSubsequence(candidates, 0,target,list, res);
		return res;

    }
}
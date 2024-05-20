class Solution {
    public void findCombinationSum(int[] candidates, int index, int target, List<List<Integer>> combinations, List<Integer> list)
    {
        if(index == candidates.length)
        {
            if(target == 0)
            {
                combinations.add(new ArrayList<>(list));
            }
            return;
        }
        if(candidates[index] <= target)
        {
            list.add(candidates[index]);
            findCombinationSum(candidates,index,target - candidates[index],combinations, list);
            list.remove(list.size()-1);
        }
        findCombinationSum(candidates,index+1, target,combinations, list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findCombinationSum(candidates, 0, target, combinations,list);
        return combinations;
    }
}
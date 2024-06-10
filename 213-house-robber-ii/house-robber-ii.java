class Solution {
    public int robHouse(ArrayList<Integer> list)
    {
        int prev2 = 0;
        int prev = list.get(0);
        for(int i = 1;i<list.size();i++)
        {
            int pick = list.get(i);
            if(i>1)
                pick+=prev2;
            int nonPick = prev;
            int curr = Math.max(pick,nonPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1)
            return nums[0];
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i<n;i++)
        {
            if(i != 0)
                list1.add(nums[i]);
            if(i != nums.length-1)
                list2.add(nums[i]);
        }
        int nIncluded = robHouse(list1);
        int nExcluded = robHouse(list2);
        return Math.max(nIncluded,nExcluded);
    }
}
class Solution {
    public int atmostKDistinct(int[] nums,int k)
    {
        int left = 0, right = 0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(right<nums.length)
        {
            map.put(nums[right], map.getOrDefault(nums[right],0) + 1);
            while(map.size() > k)
            {
                map.put(nums[left],map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }
            if(map.size() <= k)
                count+= (right - left + 1);
            right++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int res = atmostKDistinct(nums,k) - atmostKDistinct(nums,k-1);
        return res;
    }
}
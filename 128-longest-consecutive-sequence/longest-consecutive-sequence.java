class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                int left = map.containsKey(nums[i] -1) ? map.get(nums[i] - 1) : 0;
                int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
                int length = left + right + 1;
                maxLength = Math.max(length, maxLength);
                map.put(nums[i], length);
                map.put(nums[i] - left, length);
                map.put(nums[i] + right, length);
            }
            else
                continue;
        }
        return maxLength;
    }
}
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int positiveProducts = nums[n-1]* nums[n-2]*nums[n-3];
        int startEndProducts = nums[0] * nums[1] * nums[n-1];
        return Math.max(positiveProducts,startEndProducts);

    }
}

// [1,2,0,-10,2,-5,5]
// [-10,-5,0,1,2,2,5]
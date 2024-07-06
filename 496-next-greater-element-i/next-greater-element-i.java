class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        for(int i = 0; i<nums1.length;i++)
        {
            int greater = -1;
            int j = nums2.length - 1;
            while(j >= 0 && nums1[i] != nums2[j])
            {
                if(nums2[j] > nums1[i])
                {
                    greater = nums2[j];
                }
                j--;
            }
            res[i] = greater;
        }
        return res;
    }
}
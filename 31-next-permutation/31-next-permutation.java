class Solution {
    public void reverse(int[] nums, int s,int e)
    {
        while(s<e)
        {
            swap(nums,s++,e--);
        }
    }
    public void swap(int a[], int i,int j)
    {
        int temp = a[j];
        a[j]=a[i];
        a[i]=temp;
     
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        if(i>=0)
        {
            int j = nums.length-1;
            while(nums[j]<=nums[i])
                j--;
            swap(nums,i,j);
        } 
        reverse(nums,i+1,nums.length-1);
    }
}
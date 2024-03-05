class Solution {
    public void sortColors(int[] nums) {
        int countzero = 0, countone = 0;
        for(int i = 0;i < nums.length;i++)
        {
            if(nums[i] == 0)
                countzero++;
            else if(nums[i] == 1)
                countone++;
        }
        
       for(int i = 0;i<nums.length;i++)
       {
           if(i< countzero)
           {
               nums[i] = 0;
           }
           else if(i<countone+countzero)
           {
               nums[i] = 1;
           }
           else if(i>=countone+countzero)
               nums[i] = 2;
       }
    }
}
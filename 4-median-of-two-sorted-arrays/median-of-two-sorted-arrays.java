class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 && n == 0)
            return 0.0;
        int totLength = m + n;
        int index1 = totLength/2;
        int index2 = totLength/2 - 1;
        int index1Ele = Integer.MIN_VALUE;
        int index2Ele = Integer.MIN_VALUE;
        int i = 0, j = 0, count = 0;
        while(i < m && j < n)
        {
            if(nums1[i] <= nums2[j])
            {
                if(index1 == count)
                    index1Ele = nums1[i];
                if(index2 == count)
                    index2Ele = nums1[i];
                count++;
                i++;
            }
            else
            {
                if(index1 == count)
                    index1Ele = nums2[j];
                if(index2 == count)
                    index2Ele = nums2[j];
                count++;j++;
            }
        }
        while(i < m)
        {
            if(index1 == count)
                index1Ele = nums1[i];
            if(index2 == count)
                index2Ele = nums1[i];
            count++;
            i++;
        }
        while(j < n)
        {
            if(index1 == count)
                index1Ele = nums2[j];
            if(index2 == count)
                index2Ele = nums2[j];
            count++;j++; 
        }
        if(totLength % 2 != 0)
            return index1Ele;
        else
            return (index1Ele + index2Ele)/2.0;
    }
}
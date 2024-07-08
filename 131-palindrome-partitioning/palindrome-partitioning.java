class Solution {
    public boolean isPalindrome(int left,int right, String s)
    {
        while(left<=right)
        {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public void partitionString(int index, List<List<String>> res, List<String> list, String s)
    {
        if(index == s.length())
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<s.length();i++)
        {
            if(isPalindrome(index,i,s))
            {
                list.add(s.substring(index,i+1));
                partitionString(i+1,res,list,s);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partitionString(0,res,list,s);
        return res;
    }
}
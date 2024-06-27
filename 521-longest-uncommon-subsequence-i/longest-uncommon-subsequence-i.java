class Solution {
    public int findLUSlength(String a, String b) {
        int m = a.length();
		int n = b.length();
        if(a.equals(b))
            return -1;
        else 
            return Math.max(m,n);

    }
}
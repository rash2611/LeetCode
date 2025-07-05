class Solution {
    public int findLucky(int[] arr) {
        int maxi = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i = 0;i<arr.length;i++)
        {
            if(map.get(arr[i]) == arr[i])
            {
                maxi = Math.max(maxi,arr[i]);
            }
        }
        return maxi;
    }
}
class Tuple implements Comparable<Tuple>{
    int max, num, index;
    Tuple(int max, int num, int index)
    {
        this.max = max;
        this.num = num;
        this.index = index;
    }

    public int compareTo(Tuple other)
    {
        return Integer.compare(this.max,other.max);
    }
}
class Node{
    Node links[] = new Node[2];

    public boolean containsKey(int bit)
    {
        return links[bit] != null;
    }

    public void put(int bit, Node node)
    {
        links[bit] = node;
    }

    public Node get(int bit)
    {
        return links[bit];
    }
}

class Trie{
    Node root;
    Trie()
    {
        root = new Node();
    }

    public void insertNum(int num)
    {
        Node node = root;
        for(int i = 31;i>=0;i--)
        {
            int bit = (num >> i)& 1;
            if(!node.containsKey(bit))
            {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int findXor(int num)
    {
        Node node = root;
        int maxNum = 0;
        for(int i = 31;i>=0;i--)
        {
            int bit = (num >> i)& 1;
            if(node.containsKey(1 - bit))
            {
                maxNum |= (1<<i);
                node = node.get( 1 - bit);
            }
            else
            {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}
class Solution {
    Trie trie = new Trie();
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int answer[] = new int[queries.length];
        Arrays.sort(nums);
        ArrayList<Tuple> offlineQueries = new ArrayList<>();
        for(int i = 0; i<queries.length;i++)
        {
            int number = queries[i][0];
            int maxValue = queries[i][1];
            offlineQueries.add(new Tuple(maxValue, number, i));
        }
        Collections.sort(offlineQueries);
        int i = 0;
        for(int  j= 0;j<offlineQueries.size();j++)
        {
            while(i<nums.length && nums[i]<=offlineQueries.get(j).max)
            {
                trie.insertNum(nums[i]);
                i++;
            }

            if(i!=0)
            {
                answer[offlineQueries.get(j).index] = trie.findXor(offlineQueries.get(j).num);
            }
            else
            {
                answer[offlineQueries.get(j).index] = -1;
            }
        }
        return answer;
    }
}
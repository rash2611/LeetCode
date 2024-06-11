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

    public void insertNumber(int num)
    {
        Node node = root;
        for(int i = 31; i>=0; i--)
        {
            int bit = (num>>i)&1;
            if(!node.containsKey(bit))
            {
                node.put(bit,new Node());
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
            int bit = (num>>i)&1;
            if(node.containsKey(1 - bit))
            {
                maxNum |= (1 << i);
                node = node.get(1-bit);
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
    public int findMaximumXOR(int[] nums) {
        for(int i = 0;i<nums.length;i++)
        {
            trie.insertNumber(nums[i]);     
        }
        int maxXor = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++)
        {
            maxXor = Math.max(maxXor, trie.findXor(nums[i]));
        }
        return maxXor;
    }
}
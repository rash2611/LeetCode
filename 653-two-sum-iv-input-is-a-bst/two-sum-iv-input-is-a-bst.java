/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator{
    private Stack<TreeNode> stack = new Stack<>();
    boolean reverse = false;
    public BSTIterator(TreeNode root, boolean reverse)
    {
        this.reverse = reverse;
        pushAll(root);
    }
    public boolean hasNext()
    {
        return !stack.isEmpty();
    }
    public int next()
    {
        TreeNode top = stack.pop();
        if(reverse == false)
        {
            pushAll(top.right);
        }
        else
        {
            pushAll(top.left);
        }
        return top.val;
    }
    private void pushAll(TreeNode node)
    {
        while(node!=null)
        {
            stack.push(node);
            if(reverse == false)
            {
                node = node.left;
            }
            else
            {
                node = node.right;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i < j)
        {
            if(i + j == k)
                return true;
            else if(i + j > k)
                j = r.next();
            else
                i = l.next();
        }
        return false;
    }
}
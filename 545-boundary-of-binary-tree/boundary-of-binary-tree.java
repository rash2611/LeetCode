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
class Solution {
    public boolean isLeaf(TreeNode root)
    {
        return root.left == null && root.right == null;
    }
    public void leftBoundary(TreeNode root, List<Integer> res)
    {
        TreeNode curr = root.left;
        while(curr!= null)
        {
            if(!isLeaf(curr))
            {
                res.add(curr.val);
            }
            if(curr.left != null)
                curr = curr.left;
            else 
                curr = curr.right;
        }
    }
    public void rightBoundary(TreeNode root, List<Integer> res)
    {
        TreeNode curr = root.right;
        List<Integer> list = new ArrayList<>();
        while(curr != null)
        {
            if(!isLeaf(curr))
            {
                list.add(curr.val);
            }
            if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        for(int i = list.size()-1;i>=0;i--)
        {
            res.add(list.get(i));
        }
    }
    public void leafNode(TreeNode root, List<Integer> res)
    {
        if(isLeaf(root))
        {
            res.add(root.val);
            return;
        }
        if(root.left != null)
            leafNode(root.left,res);
        if(root.right != null)
            leafNode(root.right,res);

    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        if(!isLeaf(root))
            res.add(root.val);
        leftBoundary(root,res);
        leafNode(root,res);
        rightBoundary(root,res);
        return res;
    }
}
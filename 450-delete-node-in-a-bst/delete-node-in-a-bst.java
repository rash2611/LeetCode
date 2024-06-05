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
    public TreeNode findLastRight(TreeNode root)
    {
        while(root.right !=null)
        {
            root = root.right;
        }
        return root;
    }
    public TreeNode helper(TreeNode root)
    {
        if(root.left == null)
            return root.right;
        else if(root.right == null)
            return root.left;
        else{
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val == key)
        {
            return helper(root);
        }
        TreeNode curr = root;
        while(curr!= null)
        {
            if(curr.val < key)
            {
                if(curr.right != null && curr.right.val == key)
                {
                    curr.right = helper(curr.right);
                    break;
                }
                else
                {
                    curr = curr.right;
                }
            }
            else
            {
                if(curr.left!= null && curr.left.val == key)
                {
                    curr.left = helper(curr.left);
                    break;
                }
                else
                {
                    curr = curr.left;
                }
            }
        }
        return root;
    }
}
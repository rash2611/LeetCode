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
    public TreeNode flattenTree(TreeNode root, TreeNode prev)
    {
        if(root == null)
            return prev;
        prev = flattenTree(root.right,prev);
        prev = flattenTree(root.left,prev);
        root.right = prev;
        root.left = null;
        return root;
    }
    public void flatten(TreeNode root) {
        flattenTree(root, null);
    }
}
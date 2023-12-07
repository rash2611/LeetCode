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
    public int findHeight(TreeNode root){
        if(root == null)
            return 0;
        int leftSubtreeDepth = findHeight(root.left);
        int rightSubtreeDepth = findHeight(root.right);
        return Math.max(leftSubtreeDepth, rightSubtreeDepth)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return (Math.abs(leftHeight - rightHeight)) <= 1 && isBalanced(root.left) && isBalanced(root.right) ? true : false;
    }
}
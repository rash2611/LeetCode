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
    public int findDiameter(TreeNode root){
        if(root == null)
            return 0;
        int leftEdges = findDiameter(root.left);
        int rightEdges = findDiameter(root.right);
        return Math.max(leftEdges,rightEdges)+ 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);
        return Math.max((leftDiameter+rightDiameter),Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }
}
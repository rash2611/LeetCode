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
    public TreeNode constructBinaryTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map)
    {
        if(postStart > postEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(root.val);
        int numLeft = index - inStart;
        root.left = constructBinaryTree(postorder,postStart, postStart + numLeft - 1, inorder, inStart, index -1, map);
        root.right = constructBinaryTree(postorder, postStart + numLeft, postEnd - 1, inorder,index + 1, inEnd, map);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++)
        {
            map.put(inorder[i], i);
        }
        TreeNode root = constructBinaryTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }
}
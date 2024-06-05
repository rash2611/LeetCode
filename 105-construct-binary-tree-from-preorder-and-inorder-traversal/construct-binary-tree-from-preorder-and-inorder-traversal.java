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
    public TreeNode constructBinaryTree(int[] preorder, int preStart,int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map)
    {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(root.val);
        int numLeft = index - inStart;
        root.left = constructBinaryTree(preorder, preStart+1, preStart+numLeft, inorder, inStart, index-1,map);
        root.right = constructBinaryTree(preorder, preStart+numLeft +1,preEnd,inorder,index+1, inEnd,map);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length;i++)
        {
            map.put(inorder[i], i);
        }
        TreeNode root = constructBinaryTree(preorder,0,preorder.length-1, inorder, 0, inorder.length-1,map);
        return root;
    }
}
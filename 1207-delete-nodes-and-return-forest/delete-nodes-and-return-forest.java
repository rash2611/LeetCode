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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        List<TreeNode> res = new ArrayList<>();
        if(root == null || to_delete.length == 0)
            return res;
        for(int num: to_delete)
        {
            set.add(num);
        }
        if(!set.contains(root.val))
            res.add(root);
        dfs(root, set,res);
        return res;
    }
    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res)
    {
        if(node == null)
            return null;
        node.left = dfs(node.left, set,res);
        node.right = dfs(node.right, set,res);
        if(set.contains(node.val))
        {
            if(node.left!= null)
                res.add(node.left);
            if(node.right != null)
                res.add(node.right);
            return null;
        }
        return node;
    }
}
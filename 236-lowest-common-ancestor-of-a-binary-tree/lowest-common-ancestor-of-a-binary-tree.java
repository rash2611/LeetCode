/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean rootToNode(TreeNode root, TreeNode target, List<TreeNode> list)
    {
        if(root == null)
            return false;
        list.add(root);
        if(root == target)
            return true;
        if(rootToNode(root.left, target,list) || rootToNode(root.right,target,list))
            return true;
        list.remove(list.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return null;
        ArrayList<TreeNode> l1 = new ArrayList<>();
        ArrayList<TreeNode> l2 = new ArrayList<>();
        rootToNode(root, p, l1);
        rootToNode(root, q, l2);
        int i = 0;
        TreeNode descendant = null;
        while(i < l1.size() && i < l2.size() && l1.get(i) == l2.get(i))
        {
            descendant = l1.get(i);
            i++;
        }
        return descendant;
    }
}
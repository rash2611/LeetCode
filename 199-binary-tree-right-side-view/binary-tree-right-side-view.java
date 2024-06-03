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
    public void findRightView(TreeNode curr, List<Integer> list, int currDepth)
    {
        if(curr == null)
            return;
        if(list.size() == currDepth)
            list.add(curr.val);
        findRightView(curr.right, list, currDepth+1);
        findRightView(curr.left,list,currDepth+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findRightView(root, list,0);
        return list;
    }
}
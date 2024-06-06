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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        int count = 0;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !s.isEmpty())
        {
            while(curr!= null)
            {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            count++;
            if(count == k)
                break;
            curr = curr.right;
        }
        return curr.val;
    }
}
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode node = q.peek();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                if(flag== true)
                    list.add(q.poll().val);
                else
                    list.add(0,q.poll().val);
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
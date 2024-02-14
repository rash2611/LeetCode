 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty())
        {
            TreeNode top = s1.pop();
            s2.push(top);
            if(top.left != null)
                s1.push(top.left);
            if(top.right!=null)
                s1.push(top.right);
        }
        while(!s2.isEmpty())
            list.add(s2.pop().val);
        return list;
    }
}
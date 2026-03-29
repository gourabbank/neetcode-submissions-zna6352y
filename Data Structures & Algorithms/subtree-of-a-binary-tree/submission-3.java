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
    boolean flag=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root,subRoot);
        return flag;
    }
    public void dfs(TreeNode root, TreeNode subRoot)
    {
        if(root==null)return;
        if(subRoot.val==root.val)
        {
            if(check(root,subRoot)) {
                flag=true;
                return;
            }
        }
        dfs(root.left,subRoot);
        dfs(root.right,subRoot);
    }
    public boolean check(TreeNode p, TreeNode q)
    {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return check(p.left,q.left) && check(p.right,q.right);
    }
}

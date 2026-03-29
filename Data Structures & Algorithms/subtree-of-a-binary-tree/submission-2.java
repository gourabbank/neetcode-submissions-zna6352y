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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot);
    }
    public boolean dfs(TreeNode root, TreeNode subRoot)
    {
        if(root==null) return false;
        if(root.val==subRoot.val)
        {
            if(check(root,subRoot)) return true;
        }
        return dfs(root.right,subRoot) || dfs(root.left,subRoot);
    }
    public boolean check(TreeNode p, TreeNode q)
    {
        if(p==null)
        {
            if(q!=null) return false;
            return true;
        }
        else if(q==null)
        {
            if(p!=null)return false;
            return true;
        }
        if(p.val!=q.val)
        {
            return false;
        }
        return check(p.left,q.left) && check(p.right,q.right);
    }
}

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode r=dfs(root,val);
        if(r.val>val)
        {
            r.left=new TreeNode(val);
        }
        else
        {
            r.right=new TreeNode(val);
        }
        return root;
    }
    public TreeNode dfs(TreeNode root, int val)
    { 
        if(root.val<val) 
        {
            if(root.right==null) return root;
            return dfs(root.right,val);
        }
        else 
        {
            if(root.left==null) return root;
            return dfs(root.left,val);
        }
    }
}
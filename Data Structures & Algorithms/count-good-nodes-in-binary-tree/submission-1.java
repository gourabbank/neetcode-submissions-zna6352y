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
    int count=0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return count;
    }
    public void dfs(TreeNode root, int currMax)
    {
        if(root==null) return;
        if(root.val>=currMax)
        {
            currMax=root.val;
            count++;
        }
        dfs(root.left,currMax);
        dfs(root.right,currMax);
    }
}

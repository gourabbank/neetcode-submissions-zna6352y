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
    int cnt=0;
    int small=1001;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return small;
    }
    public void dfs(TreeNode root, int k)
    {
        if(root==null) {
            cnt++;
            return;
        }
        dfs(root.left,k);
        if(cnt==k)
        {
            small=root.val;
        }
        dfs(root.right,k);
    }
}

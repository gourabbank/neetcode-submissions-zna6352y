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

public class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb=new StringBuilder();
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }
    public void dfs(TreeNode root)
    {
        if(root==null) {
            sb.append("n.");
            return;
        }
        sb.append(root.val);
        sb.append('.');
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split("\\.");
        return recurse(arr);
    }
    int idx=0;
    public TreeNode recurse(String[] arr)
    {
        if(arr[idx].equals("n"))
        {
            idx++;
            return null;
        }
        TreeNode curr=new TreeNode(Integer.parseInt(arr[idx]));
        idx++;
        curr.left=recurse(arr);
        curr.right=recurse(arr);
        return curr;
    }
}

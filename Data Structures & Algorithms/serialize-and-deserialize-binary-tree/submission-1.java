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
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }
    public void dfs(TreeNode root, StringBuilder sb)
    {
        if(root==null) 
        {
            sb.append("n#");
            return;
        }
        sb.append(root.val);
        sb.append("#");
        dfs(root.left,sb);
        dfs(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals=data.split("#");
        int[] i={0};
        return sfd(vals,i);
        
    }

    public TreeNode sfd(String[] vals, int[] i)
    {
        if(vals[i[0]].equals("n"))
        {
            i[0]++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left=sfd(vals,i);
        node.right=sfd(vals,i);
        return node;
    }
}

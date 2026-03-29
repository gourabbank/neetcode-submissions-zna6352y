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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sol=new ArrayList<>();
        if(root==null) return sol;
        List<Integer> curr=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            curr=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode t=q.poll();
                curr.add(t.val);
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
            }
            sol.add(new ArrayList<>(curr));
        }
        return sol;
    }
}

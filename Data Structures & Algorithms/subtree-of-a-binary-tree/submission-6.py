# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    flag=False
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        self.dfs(root,subRoot)
        return self.flag
    def dfs(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]):
        if not root:
            return
        if root.val==subRoot.val:
            if self.check(root,subRoot):
                self.flag=True
                return
        self.dfs(root.left,subRoot)
        self.dfs(root.right,subRoot)
    def check(self, p:Optional[TreeNode], q:Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val!=q.val:
            return False
        return self.check(p.left,q.left) and self.check(p.right,q.right)
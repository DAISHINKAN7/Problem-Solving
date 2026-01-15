from typing import Optional
class TreeNode:
    def __init__(self, val = 0,left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = [root.val]

        def dfs(root):
            if not root:
                return 0

            left = max(dfs(root.left), 0)
            right = max(dfs(root.right), 0)

            #compute the max path with split
            res[0] = max(res[0], root.val + left + right)

            #return the max path without split
            return root.val + max(left, right)

        dfs(root)
        return res[0]
    
s = Solution()
print(s.maxPathSum(TreeNode(-10, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))))  # Output: 42
print(s.maxPathSum(TreeNode(1, TreeNode(2), TreeNode(3))))  # Output: 6
print(s.maxPathSum(TreeNode(-3)))  # Output: -3
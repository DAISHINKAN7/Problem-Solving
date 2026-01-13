class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(node, maxVal):
            if not node:
                return 0
            
            goodNodes = 1 if node.val >= maxVal else 0
            maxVal = max(maxVal, node.val)

            goodNodes += dfs(node.left, maxVal)
            goodNodes += dfs(node.right, maxVal)

            return goodNodes

        return dfs(root, root.val)
    
s = Solution()
print(s.goodNodes(TreeNode(3, TreeNode(1, TreeNode(3)), TreeNode(4, None, TreeNode(5)))))  # Output: 4
print(s.goodNodes(TreeNode(3, TreeNode(3, TreeNode(4), TreeNode(2)), TreeNode(4, None, TreeNode(5)))))  # Output: 5
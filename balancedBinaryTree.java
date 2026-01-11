public class balancedBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }

        int leftHeight = getMaxSubtreeHeight(root.left);
        int rightHeight = getMaxSubtreeHeight(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 &&
               isBalanced(root.left) &&
               isBalanced(root.right);
    }

    private int getMaxSubtreeHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = getMaxSubtreeHeight(node.left);
        int rightHeight = getMaxSubtreeHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        balancedBinaryTree solution = new balancedBinaryTree();
        // Example usage:
        TreeNode balancedRoot = solution.new TreeNode(3, 
                                    solution.new TreeNode(9), 
                                    solution.new TreeNode(20, 
                                        solution.new TreeNode(15), 
                                        solution.new TreeNode(7)));
        TreeNode unbalancedRoot = solution.new TreeNode(1, 
                                        solution.new TreeNode(2, 
                                            solution.new TreeNode(3, 
                                                solution.new TreeNode(4), null), null), null);

        boolean isBalanced1 = solution.isBalanced(balancedRoot);
        boolean isBalanced2 = solution.isBalanced(unbalancedRoot);

        System.out.println(isBalanced1); // Should print true
        System.out.println(isBalanced2); // Should print false
    }
}

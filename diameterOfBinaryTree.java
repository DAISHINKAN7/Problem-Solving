public class diameterOfBinaryTree {
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

    private int getMaxSubtreeHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = getMaxSubtreeHeight(node.left);
        int rightHeight = getMaxSubtreeHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree1(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = getMaxSubtreeHeight(root.left);
        int rightHeight = getMaxSubtreeHeight(root.right);

        int leftDiameter = diameterOfBinaryTree1(root.left);
        int rightDiameter = diameterOfBinaryTree1(root.right);

        int currentDiamter = leftHeight + rightHeight + 1;

        return Math.max(currentDiamter, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        diameterOfBinaryTree solution = new diameterOfBinaryTree();
        // Example usage:
        TreeNode root = solution.new TreeNode(1, 
                            solution.new TreeNode(2, 
                                solution.new TreeNode(4), 
                                solution.new TreeNode(5)), 
                            solution.new TreeNode(3));
        int diameter = solution.diameterOfBinaryTree1(root);
        System.out.println(diameter); // Should print 5
    }
}

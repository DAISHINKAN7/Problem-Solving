public class maximumDepthOfTree {
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

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        maximumDepthOfTree solution = new maximumDepthOfTree();
        // Example usage:
        TreeNode root = solution.new TreeNode(3, 
                            solution.new TreeNode(9), 
                            solution.new TreeNode(20, 
                                solution.new TreeNode(15), 
                                solution.new TreeNode(7)));
        int depth = solution.maxDepth(root);
        System.out.println("Maximum Depth of the Tree: " + depth); // Should print 3
    }
}

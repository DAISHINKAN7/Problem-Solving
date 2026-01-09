public class invertBinaryTree {
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int data){
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        invertBinaryTree solution = new invertBinaryTree();
        // Example usage:
        TreeNode root = solution.new TreeNode(4, 
                            solution.new TreeNode(2, 
                                solution.new TreeNode(1), 
                                solution.new TreeNode(3)), 
                            solution.new TreeNode(7, 
                                solution.new TreeNode(6), 
                                solution.new TreeNode(9)));
        TreeNode invertedRoot = solution.invertTree(root);
        // The invertedRoot now represents the root of the inverted binary tree.    
        System.out.println(invertedRoot.data); // Should print 4
        System.out.println(invertedRoot.left.data); // Should print 7
        System.out.println(invertedRoot.right.data); // Should print 2  
    }
}

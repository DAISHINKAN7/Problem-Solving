public class validateBST {
    public class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null){
            return true;
        }

        if(min != null && root.val <= min.val){
            return false;
        }else if(max != null && root.val >= max.val){
            return false;
        }

        return validate(root.left, min, root) && validate(root.right, root, max);
    }
    
    public static void main(String[] args){
        validateBST solution = new validateBST();
        // Example usage:
        TreeNode root = solution.new TreeNode(2, 
                            solution.new TreeNode(1), 
                            solution.new TreeNode(3));
        boolean isValid = solution.isValidBST(root);
        System.out.println(isValid); // Output: true
    }
}
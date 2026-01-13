public class lowestCommonAncestorOfBST{
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    } 
    public static void main(String[] args) {
        lowestCommonAncestorOfBST solution = new lowestCommonAncestorOfBST();
        // Example usage:
        TreeNode root = solution.new TreeNode(6, 
                            solution.new TreeNode(2, 
                                solution.new TreeNode(0),
                                solution.new TreeNode(4, 
                                    solution.new TreeNode(3), 
                                    solution.new TreeNode(5))), 
                            solution.new TreeNode(8, 
                                solution.new TreeNode(7), 
                                solution.new TreeNode(9)));
        TreeNode p = solution.new TreeNode(2);
        TreeNode q = solution.new TreeNode(8);
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println(lca.val); // Output:
    }
}
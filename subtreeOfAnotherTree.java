public class subtreeOfAnotherTree {
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

    public boolean isSubTree(TreeNode s, TreeNode t){
        if(s == null){
            return false;
        }

        if(s.val == t.val){
            if(isSameTree(s, t)){
                return true;
            }
        }

        return isSubTree(s.left, t) || isSubTree(s.right, t);
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args){
        subtreeOfAnotherTree solution = new subtreeOfAnotherTree();
        // Example usage:
        TreeNode s = solution.new TreeNode(3, 
                            solution.new TreeNode(4, 
                                solution.new TreeNode(1), 
                                solution.new TreeNode(2, 
                                    solution.new TreeNode(0), null)), 
                            solution.new TreeNode(5));
        TreeNode t = solution.new TreeNode(4, 
                            solution.new TreeNode(1), 
                            solution.new TreeNode(2));
        boolean result = solution.isSubTree(s, t);
        System.out.println(result); // Should print true
    }
}

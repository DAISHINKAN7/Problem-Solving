import java.util.*;
public class kthSmallestElementInBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        private void inOrderTraversal(TreeNode root, StringBuilder result){
            if(root == null){
                return;
            }
            inOrderTraversal(root.left, result);
            result.append(root.val).append(" ");
            inOrderTraversal(root.right, result);
        }

        public int kthSmallest(TreeNode root, int k){
            if(root == null){
                return -1;
            }

            StringBuilder inOrder = new StringBuilder();
            inOrderTraversal(root, inOrder);
            
            String[] values = inOrder.toString().split(" ");
            return Integer.parseInt(values[k-1]);
        }
    }

    public static void main(String[] args){
        kthSmallestElementInBST solution = new kthSmallestElementInBST();
        // Example usage:
        TreeNode root = solution.new TreeNode(3, 
                            solution.new TreeNode(1, 
                                null, 
                                solution.new TreeNode(2)), 
                            solution.new TreeNode(4));
        int k = 1;
        int kthSmallest = root.kthSmallest(root, k);
        System.out.println(kthSmallest); // Output: 1
    }
}

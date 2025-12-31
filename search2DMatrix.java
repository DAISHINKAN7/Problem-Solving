public class search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0; int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        search2DMatrix sm = new search2DMatrix();
        int[][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target1 = 3;
        int[][] matrix2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target2 = 13;
        System.out.println(sm.searchMatrix(matrix1,target1)); // Output: true
        System.out.println(sm.searchMatrix(matrix2,target2)); // Output: false
    }
}

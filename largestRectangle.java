import java.util.Stack;

public class largestRectangle {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];

        //Next Smaller right
        Stack<Integer> s = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--){
            while(!s.empty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.empty()){
                nsr[i] = heights.length;
            }else{
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        //Next Smaller left
        s = new Stack<>();
        for(int j = 0; j<heights.length; j++){
            while(!s.empty() && heights[s.peek()] >= heights[j]){
                s.pop();
            }
            if(s.empty()){
                nsl[j] = -1;
            }else{
                nsl[j] = s.peek();
            }

            s.push(j);
        }

        //width = j - i - 1 = nsr[j] - nsl[j] - 1
        for(int k = 0; k<heights.length; k++){
            int width = nsr[k] - nsl[k] - 1;
            int height = heights[k];
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        largestRectangle lr = new largestRectangle();
        int[] heights1 = {2,1,5,6,2,3};
        int[] heights2 = {2,4};
        int[] heights3 = {6,2,5,4,5,1,6};

        System.out.println(lr.largestRectangleArea(heights1)); // Output: 10
        System.out.println(lr.largestRectangleArea(heights2)); // Output: 4
        System.out.println(lr.largestRectangleArea(heights3)); // Output: 12
    }
}

import java.util.Stack;
public class dailyTemperatures {
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            } else {
                result[i] = 0;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        dailyTemperatures dt = new dailyTemperatures();
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {30, 40, 50, 60};
        int[] temperatures3 = {30, 60, 90};
        
        System.out.println(java.util.Arrays.toString(dt.dailyTemperatures1(temperatures1))); // Output: [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(java.util.Arrays.toString(dt.dailyTemperatures1(temperatures2))); // Output: [1, 1, 1, 0]
        System.out.println(java.util.Arrays.toString(dt.dailyTemperatures1(temperatures3))); // Output: [1, 1, 0]
    }
}

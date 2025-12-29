import java.util.ArrayList;
import java.util.List;

public class generateParentheses {
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public void backtrack(List<String> result, String current, int open, int close, int max){
        // base case
        if(current.length() == max * 2){
            result.add(current);
            return;
        }

        if(open < max){
            backtrack(result, current + "(", open + 1, close, max);
        }

        if(close < open){
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args){
        generateParentheses gp = new generateParentheses();
        int n1 = 3;
        int n2 = 1;
        System.out.println(gp.generateParenthesis(n1)); // Output: ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(gp.generateParenthesis(n2)); // Output: ["()"]
    }
}

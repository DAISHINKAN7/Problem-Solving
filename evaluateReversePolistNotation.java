import java.util.Stack;
public class evaluateReversePolistNotation {
    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token:tokens){
            if((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/"))){
                int b = stack.pop();
                int a = stack.pop();
                switch(token){
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        evaluateReversePolistNotation erpn = new evaluateReversePolistNotation();
        String[] tokens1 = {"2","1","+","3","*"};
        String[] tokens2 = {"4","13","5","/","+"};
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(erpn.evalRPN(tokens1)); // Output: 9
        System.out.println(erpn.evalRPN(tokens2)); // Output: 6
        System.out.println(erpn.evalRPN(tokens3)); // Output: 22
    }
}

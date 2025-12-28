import java.util.Stack;
public class validParenthesis{
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack <>();
        for(int i  = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if((ch == ')' && stack.peek() == '(') || 
                (ch == '}' && stack.peek() == '{') || 
                (ch == ']' && stack.peek() == '[')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args){
        validParenthesis vp = new validParenthesis();
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";
        String s5 = "([)]";
        String s6 = "]";
        System.out.println(vp.isValid(s1));
        System.out.println(vp.isValid(s2));
        System.out.println(vp.isValid(s3));
        System.out.println(vp.isValid(s4));
        System.out.println(vp.isValid(s5));
        System.out.println(vp.isValid(s6));
    }
}
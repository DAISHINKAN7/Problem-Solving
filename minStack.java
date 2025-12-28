import java.util.Stack;
class minStack{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop(){
        stack.pop();
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args){
        minStack ms = new minStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin()); // return -3
        ms.pop();
        System.out.println(ms.top());    // return 0
        System.out.println(ms.getMin()); // return -2
    }
}
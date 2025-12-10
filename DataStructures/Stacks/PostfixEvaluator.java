package Stacks;
import java.util.Stack;

public class PostfixEvaluator {
    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            switch (token) {
                case "+": stack.push(stack.pop() + stack.pop()); break;
                case "-": {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a - b); break;
                }
                case "*": stack.push(stack.pop() * stack.pop()); break;
                case "/": {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a / b); break;
                }
                default: stack.push(Integer.parseInt(token));
            }
            System.out.println("Token: " + token + ", Stack: " + stack);
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "5 2 4 * + 9 - 3 /";
        System.out.println("Result: " + evaluate(postfix));
    }
}

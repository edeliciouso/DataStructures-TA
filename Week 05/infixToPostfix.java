import java.util.Stack;
import java.util.Scanner;

public class infixToPostfix {
    public static int order(char ch) {
        switch(ch) { // order of the operators
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixPostfix(String infix) {
        String postfix = new String("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                postfix += ch; // add the character to the postfix result
            } else if(ch == '('){
                stack.push(ch); // put ( in the stack
            } else if (ch == ')') { // if there's )
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() != '(') {
                    return "Expression doesn't work.";
                } else {
                    stack.pop();
                }
            }
            else { // when there is an operator
                while(!stack.isEmpty() && order(ch) <= order(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()) { // pop all operators from the stack
            if(stack.peek() == '(') {
                return "Expression doesn't work.";
            }
            postfix += stack.peek();
            stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args){
        String input;
        System.out.println("Insert an infix expression:");
        Scanner scn = new Scanner(System.in);
        input = scn.nextLine();

        String postfixes = infixPostfix(input);
        System.out.println("Infix: " + input);
        System.out.println("Postfix: " + postfixes);
    }
}

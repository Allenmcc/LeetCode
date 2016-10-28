package easy;

import java.util.Stack;

/**
 * Created by danny on 2016/10/17.
 */
public class ValidParentheses {
    public  boolean isValid(String s){

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            } else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            } else {
                //其他情况，不合法
                return false;
            }
        }
        //返回值，栈空则合法，有值则不合法。
        return stack.empty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (stack.size() == 0 || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.size() == 0 || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.size() == 0 || stack.pop() != '[')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        String s = "{()}";
        boolean valid = new ValidParentheses().isValid(s);
        System.out.print(valid);

    }

}

package com.ds.stack;

import java.util.Stack;

public class ParenthesisChecker {
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            if(ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty() || !isValid(stack.peek(), ch))
                    return false;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    private static boolean isValid(char topChar, char currentChar) {
        return (topChar == '(' && currentChar == ')')
                || (topChar == '{' && currentChar == '}')
                || (topChar == '[' && currentChar == ']');
    }

    public static void main(String[] args) {

    }
}

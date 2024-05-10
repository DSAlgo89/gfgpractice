package com.ds.stack;

import java.util.Stack;

public class LongestValidParenthesis {
    static int maxLength(String S){
        // code here
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int max = 0;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }
                max = Integer.max(max, (i - stack.peek()));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(maxLength("((()"));
    }
}

package com.ds.stack;

import java.util.Stack;

public class RestrictiveCandyCrush {
    public static String reduced_String(int k, String s)
    {
        // Your code goes here
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                int count = k - 1;
                while(count-- >= 0 && !stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                }
                //stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String ans = reduced_String(2, "geeksforgeeks");

        System.out.println(ans);
    }
}

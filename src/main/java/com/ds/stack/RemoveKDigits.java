package com.ds.stack;


import java.util.Stack;

public class RemoveKDigits {
    private static String removeKdigits(String S, int K) {
        // code here
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for(int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(ch < stack.peek()) {
                while(!stack.isEmpty() && K > 0 && stack.peek() > ch) {
                    stack.pop();
                    K--;
                }
                stack.push(ch);
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
       // System.out.println(sb);
        if(sb.length() == 1)
            return sb.toString();

        int i = 0;
        while(sb.charAt(i) == '0' && i < sb.length() - 1) {
            i++;
        }

        return sb.substring(i);
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("149811", 3));
        System.out.println(removeKdigits("1002991", 3));
    }
}

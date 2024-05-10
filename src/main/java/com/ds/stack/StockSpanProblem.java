package com.ds.stack;

import java.util.Stack;

public class StockSpanProblem {
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n];
        span[0] = 1;
        stack.push(0);

        for(int i = 1; i < n; i++) {
            //int diff = 1;
            while(!stack.isEmpty() && price[i] > price[stack.peek()]) {
                //diff++;
                stack.pop();
            }
            span[i] = stack.isEmpty() ? i: (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {

    }
}

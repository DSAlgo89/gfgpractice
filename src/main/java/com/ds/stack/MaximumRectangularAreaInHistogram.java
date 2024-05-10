package com.ds.stack;

import java.util.Stack;

public class MaximumRectangularAreaInHistogram {
    public static long getMaxArea(long hist[], long n)
    {
        // your code here
        int[] prevSmaller = new int[(int)n];
        int[] nextSmaller = new int[(int)n];
        calculatePreviousSmaller(hist, prevSmaller, (int)n);
        calculateNextSmaller(hist, nextSmaller, (int)n);
        long maxArea = 0;
        for(int i = 0; i < prevSmaller.length; i++) {
            if(nextSmaller[i] == -1) {
                nextSmaller[i] = (int)n;
            }
            long length = hist[i];
            long breadth = nextSmaller[i] - prevSmaller[i] - 1;
            maxArea = Long.max(maxArea, length * breadth);
        }
        return maxArea;
    }

    private static void calculateNextSmaller(long[] hist, int[] nextSmaller, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = n - 1; i >= 0; i--) {
            while(stack.peek() != -1 && hist[stack.peek()] > hist[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.peek();
            stack.push(i);
        }
    }

    private static void calculatePreviousSmaller(long[] hist, int[] prevSmaller, int n) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        for(int i = 0; i < n; i++) {
            while(stack.peek() != -1 && hist[stack.peek()] > hist[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.peek();
            stack.push(i);
        }
    }


    public static void main(String[] args) {

    }
}

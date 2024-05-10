package com.ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    private static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        long[] res = new long[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = n - 1; i >= 0; i--) {
            while(stack.peek() != -1 && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if(stack.peek() != -1)
                res[i] = arr[stack.peek()];
            else
                res[i] = stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = {1,3,2,4};
        long[] res = nextLargerElement(arr, arr.length);

        System.out.println(Arrays.toString(res));
    }
}

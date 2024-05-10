package com.ds.stack;

import java.util.Stack;

public class SpecialStack {
    static class GfG{
        Stack<Integer> minStack;

        public GfG() {
            minStack = new Stack<>();
        }
        public void push(int a, Stack<Integer> s)
        {
            //add code here.
            s.push(a);
            if(minStack.isEmpty() || minStack.peek() > a) {
                minStack.push(a);
            }
        }
        public int pop(Stack<Integer> s)
        {
            //add code here.
            int item = s.pop();
            if(minStack.peek() == item) {
                minStack.pop();
            }
            return item;
        }
        public int min(Stack<Integer> s)
        {
            //add code here.
            if(minStack.isEmpty())
                return Integer.MIN_VALUE;
            return minStack.peek();
        }
        public boolean isFull(Stack<Integer>s, int n)
        {
            //add code here.
            return s.size() == n;
        }
        public boolean isEmpty(Stack<Integer>s)
        {
            //add code here.
            return s.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}

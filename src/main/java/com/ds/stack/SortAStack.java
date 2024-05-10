package com.ds.stack;

import java.util.Stack;

public class SortAStack {
    public Stack<Integer> sort(Stack<Integer> s)
    {
        //add code here.
        sortStack(s);
        return s;
    }

    private static void sortStack(Stack<Integer> s) {
        if(!s.isEmpty()) {
            int x = s.pop();

            sortStack(s);

            sortedInsert(s, x);
        }
    }

    private static void sortedInsert(Stack<Integer> s, int x) {
        if(s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }

        int temp = s.pop();
        sortedInsert(s, x);

        s.push(temp);
    }

    public static void main(String[] args) {

    }
}

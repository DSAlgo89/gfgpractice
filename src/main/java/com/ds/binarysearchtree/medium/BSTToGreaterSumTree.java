package com.ds.binarysearchtree.medium;

import com.ds.binarysearchtree.easy.CheckForBST;

import java.util.Stack;

public class BSTToGreaterSumTree {
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            left=null;
            right=null;
        }
    }

    public static void transformTree (Node root)
    {
        //code here
        int sumSoFar = 0;
        Stack<Node> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            int data = root.data;
            root.data = sumSoFar;
            sumSoFar += data;
            root = root.left;
        }
    }

    public static void main(String[] args) {

    }
}

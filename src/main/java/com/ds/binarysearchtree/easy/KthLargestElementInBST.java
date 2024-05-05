package com.ds.binarysearchtree.easy;

import java.util.Stack;

public class KthLargestElementInBST {

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

    public static int kthLargest(Node root,int K)
    {
        //Your code here
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.right;
            }

            root = stack.pop();
            K--;
            if(K == 0) {
                return root.data;
            }
            root = root.left;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}

package com.ds.binarytree;

public class BalancedTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    static boolean isBalanced(Node root)
    {
        // Your code here
        int balance = checkBalance(root);
        return balance == -1 ? false: true;
    }

    private static int checkBalance(Node root) {
        if(root == null)
            return 0;
        int left = checkBalance(root.left);
        if(left == -1)
            return -1;
        int right = checkBalance(root.right);
        if(right == -1)
            return -1;
        int diff = Math.abs(left - right);
        if(diff > 1)
            return -1;
        return 1 + Integer.max(left, right);
    }


    public static void main(String[] args) {

    }
}

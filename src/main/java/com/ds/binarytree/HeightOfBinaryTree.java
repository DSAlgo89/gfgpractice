package com.ds.binarytree;

public class HeightOfBinaryTree {
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    static int height(Node node)
    {
        // code here
        if(node == null)
            return 0;
        int left = height(node.left);
        int right = height(node.right);
        return 1 + Integer.max(left, right);
    }

    public static void main(String[] args) {

    }
}

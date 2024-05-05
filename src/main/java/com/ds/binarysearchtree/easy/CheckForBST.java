package com.ds.binarysearchtree.easy;

public class CheckForBST {
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

    static boolean isBST(Node root)
    {
        // code here.
        return isBSTRec(root, 2L * Integer.MIN_VALUE, 2L * Integer.MAX_VALUE);
    }

    private static boolean isBSTRec(Node root, long min, long max) {
        if(root == null)
            return true;
        if(root.data <= min || root.data >= max)
            return false;
        return isBSTRec(root.left, min, root.data) &&
                isBSTRec(root.right, root.data, max);
    }


    public static void main(String[] args) {

    }
}

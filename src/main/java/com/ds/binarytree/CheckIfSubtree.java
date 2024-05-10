package com.ds.binarytree;

public class CheckIfSubtree {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if(T == null && S == null)
            return true;
        if(T == null)
            return false;
        if(T.data == S.data) {
            boolean isIdentical = isIdentical(T, S);
            if(isIdentical)
                return true;
        }

        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    private static boolean isIdentical(Node t, Node s) {
        if(t == null && s == null)
            return true;
        if(t == null || s == null)
            return false;
        return t.data == s.data && isIdentical(t.left, s.left)
                && isIdentical(t.right, s.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);

        Node root1 = new Node(3);
        root1.left = new Node(4);

        System.out.println(isSubtree(root, root1));
    }
}

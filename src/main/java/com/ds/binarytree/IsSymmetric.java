package com.ds.binarytree;

public class IsSymmetric {
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

    public static boolean isSymmetric(Node root)
    {
        // add your code here;
        if(root == null || (root.left == null && root.right == null))
            return true;
        Node left = root.left;
        Node right = root.right;
        return isSymmetricRec(left, right);
    }

    private static boolean isSymmetricRec(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return root1.data == root2.data &&
                isSymmetricRec(root1.left, root2.right)
        && isSymmetricRec(root1.right, root2.left);
    }

    public static void main(String[] args) {

    }
}

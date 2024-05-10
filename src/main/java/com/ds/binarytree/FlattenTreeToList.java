package com.ds.binarytree;

public class FlattenTreeToList {

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

    public static void flatten(Node root)
    {
        //code here
        flattenRec(root);
    }

    private static Node flattenRec(Node root) {
        if(root == null)
            return null;
        Node left = flattenRec(root.left);
        Node right = flattenRec(root.right);


        root.left = null;
        root.right = left;

        Node temp = root;
        while(temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.right = new Node(6);

        flatten(root);

        Node temp = root;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.right;
        }
    }
}

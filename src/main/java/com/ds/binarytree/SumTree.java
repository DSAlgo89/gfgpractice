package com.ds.binarytree;

public class SumTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }


    static boolean isSumTree(Node root)
    {
        // Your code here
        int ans = isEqual(root);
        return ans == -1 ? false: true;
    }

    static int isEqual(Node root) {
        if(root == null) {
            return 0;
        }
        int left = isEqual(root.left);
        if(left == -1)
            return -1;
        int right = isEqual(root.right);
        if(right == -1)
            return -1;
        if(root.left == null && root.right == null)
            return root.data;
        if(root.data != (left + right)) {
            return -1;
        }
        return root.data + left + right;
    }

    public static void main(String[] args) {

    }
}

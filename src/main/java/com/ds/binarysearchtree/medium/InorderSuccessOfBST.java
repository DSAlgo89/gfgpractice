package com.ds.binarysearchtree.medium;

import java.util.Stack;

public class InorderSuccessOfBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node inorderSuccessor(Node root, Node x) {
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            Node item = stack.pop();
            if(item == x) {
                if(item.right == null) {
                    return !stack.isEmpty() ? stack.peek(): null;
                } else {
                    item = item.right;
                    while(item.left != null) {
                        item = item.left;
                    }
                    return item;
                }
            }
            root = item.right;
        }
        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Node ans = inorderSuccessor(root, root.left.left);
        if(ans == null) {
            System.out.println("Empty");
        } else {
            System.out.println(ans.data);
        }
    }
}

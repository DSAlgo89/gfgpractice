package com.ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderTraversal {
    static class Node {
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    }

    static ArrayList<Integer> inOrder(Node root)
    {
        // Code
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.data);

            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result = inOrder(root);

        System.out.println(result);
    }
}

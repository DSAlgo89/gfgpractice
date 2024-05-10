package com.ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrderTraversal {
    static class Node {
        int data;
        Node left, right;
        Node(int item)    {
            data = item;
            left = right = null;
        }
    }

    static ArrayList<Integer> preOrder(Node root)
    {
        // Code
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.data);

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result = preOrder(root);

        System.out.println(result);
    }
}

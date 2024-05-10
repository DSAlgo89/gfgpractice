package com.ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {
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

    private static ArrayList<Integer> postOrder(Node node) {
        // code here
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);

        while(!stack1.isEmpty()) {
            Node root = stack1.pop();
            stack2.push(root);

            if(root.left != null) {
                stack1.push(root.left);
            }

            if(root.right != null) {
                stack1.push(root.right);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!stack2.isEmpty()) {
            result.add(stack2.pop().data);
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> result = postOrder(root);

        System.out.println(result);
    }
}

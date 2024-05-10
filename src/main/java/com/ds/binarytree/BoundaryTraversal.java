package com.ds.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BoundaryTraversal {
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

    static ArrayList<Integer> boundary(Node node)
    {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(node.data);
        traverseLeft(node.left, result);
        traverseBottom(node.left, result);
        traverseBottom(node.right, result);
        traverseRight(node.right, result);
        return result;
    }

    private static void traverseBottom(Node root, ArrayList<Integer> result) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            result.add(root.data);
        }
        traverseBottom(root.left, result);
        traverseBottom(root.right, result);
    }

    private static void traverseRight(Node root, ArrayList<Integer> result) {
        if(root == null)
            return;
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node remNode = queue.poll();

            if(remNode.left == null && remNode.right == null) {
                continue;
            }

            temp.add(remNode.data);

            if(remNode.right != null) {
                queue.add(remNode.right);
            } else if(remNode.left != null) {
                queue.add(remNode.left);
            }
        }

        Collections.reverse(temp);
        result.addAll(temp);
    }

    private static void traverseLeft(Node root, ArrayList<Integer> result) {
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node remNode = queue.poll();
            if(remNode.left == null && remNode.right == null) {
                continue;
            }
            result.add(remNode.data);
            if(remNode.left != null) {
                queue.add(remNode.left);
            } else if(remNode.right != null) {
                queue.add(remNode.right);
            }
        }
    }



    public static void main(String[] args) {

    }
}

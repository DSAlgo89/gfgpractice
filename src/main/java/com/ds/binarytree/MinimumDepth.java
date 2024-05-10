package com.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {
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


    static int minDepth(Node root)
    {
        //code here
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                if(node.left == null && node.right == null) {
                    return count + 1;
                }

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            count++;
        }
        return count + 1;
    }

    public static void main(String[] args) {

    }
}

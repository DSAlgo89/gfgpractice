package com.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class RootToLeafPath {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class TreeItem {
        Node node;
        long valueSoFar;

        public TreeItem(Node node, long valueSoFar) {
            this.node = node;
            this.valueSoFar = valueSoFar;
        }
    }

    public static long treePathsSum(Node root)
    {
        //add code here.
        Queue<TreeItem> queue = new LinkedList<>();
        queue.add(new TreeItem(root, root.data));

        long sum = 0;
        while(!queue.isEmpty()) {
            TreeItem remItem = queue.poll();

            if(remItem.node.left == null && remItem.node.right == null) {
                sum += remItem.valueSoFar;
                continue;
            }

            if(remItem.node.left != null) {
                long valueSoFar = remItem.valueSoFar * 10 + remItem.node.left.data;
                TreeItem newItem = new TreeItem(remItem.node.left, valueSoFar);
                queue.add(newItem);
            }

            if(remItem.node.right != null) {
                long valueSoFar = remItem.valueSoFar * 10 + remItem.node.right.data;
                TreeItem newItem = new TreeItem(remItem.node.right, valueSoFar);
                queue.add(newItem);
            }
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}

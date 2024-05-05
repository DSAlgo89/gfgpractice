package com.ds.binarysearchtree.medium;

public class LargestBSTInBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int val) {
            this.data = val;
        }
    }

    static class TreeItem {
        int smallest;
        int largest;
        int numNodes;

        public TreeItem(int smallest, int largest, int numNodes) {
            this.smallest = smallest;
            this.largest = largest;
            this.numNodes = numNodes;
        }
    }


    static int largestBst(Node root) {
        // Write your code here

        TreeItem treeItem = largestBstRec(root);
        return treeItem.numNodes;
    }

    private static TreeItem largestBstRec(Node root) {
        if(root == null)
            return new TreeItem(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        TreeItem left = largestBstRec(root.left);
        TreeItem right = largestBstRec(root.right);
        if(root.data > left.largest && root.data < right.smallest) {
            int currentSmallest = Integer.min(left.smallest, root.data);
            int currentLargest = Integer.max(right.largest, root.data);
            int totalSize = 1 + left.numNodes + right.numNodes;
            return new TreeItem(currentSmallest, currentLargest, totalSize);
        }
        return new TreeItem(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.max(left.numNodes, right.numNodes));
    }


    public static void main(String[] args) {

    }
}

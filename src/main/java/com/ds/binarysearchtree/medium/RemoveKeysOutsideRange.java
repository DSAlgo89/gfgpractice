package com.ds.binarysearchtree.medium;

import java.util.ArrayList;
import java.util.List;

public class RemoveKeysOutsideRange {
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            left=null;
            right=null;
        }
    }

    static Node removekeys(Node root, int l, int r) {
        // code here
        List<Integer> nodeList = new ArrayList<>();
        pruneTree(root, l, r, nodeList);
        root = buildBST(nodeList, 0, nodeList.size() - 1);
        return root;
    }

    private static Node buildBST(List<Integer> node, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) >> 1;
        Node root = new Node(node.get(mid));
        root.left = buildBST(node, start, mid - 1);
        root.right = buildBST(node, mid + 1, end);
        return root;
    }

    private static void pruneTree(Node root, int min, int max, List<Integer> node) {
        if(root == null) {
            return;
        }
        pruneTree(root.left, min, max, node);
        if(root.data >= min && root.data <= max) {
            node.add(root.data);
        }
        pruneTree(root.right, min, max, node);
    }

    public static void main(String[] args) {

    }
}

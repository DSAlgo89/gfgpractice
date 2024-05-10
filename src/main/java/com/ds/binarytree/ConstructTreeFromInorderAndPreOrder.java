package com.ds.binarytree;


public class ConstructTreeFromInorderAndPreOrder {
    static class Node
    {
        int data;
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }

    static int preIndx = 0;

    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here
        return buildTreeRec(inorder, preorder, 0, n - 1);
    }

    private static Node buildTreeRec(int[] inorder, int[] preorder, int start, int end) {
        if(start > end)
            return null;
        int inIndx = search(inorder, preorder[preIndx], start, end);
        preIndx++;
        Node node = new Node(inorder[inIndx]);
        node.left = buildTreeRec(inorder, preorder, start, inIndx - 1);
        node.right = buildTreeRec(inorder, preorder, inIndx + 1, end);
        return node;
    }

    private static int search(int[] inorder, int item, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == item)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}

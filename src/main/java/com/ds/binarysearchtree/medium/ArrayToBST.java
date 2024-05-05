package com.ds.binarysearchtree.medium;

public class ArrayToBST {
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

    static int indx = 0;

    private static int[] sortedArrayToBST(int[] nums) {
        // Code here
        Node root = buildBST(nums,0, nums.length-1);
        int[] pre = new int[nums.length];
        preorder(root, pre);
        return pre;
    }

    private static void preorder(Node root, int[] pre) {
        if(root == null)
            return;
        pre[indx++] = root.data;
        preorder(root.left, pre);
        preorder(root.right, pre);
    }


    private static Node buildBST(int[] nums, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) >> 1;
        Node root = new Node(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }


    public static void main(String[] args) {

    }
}

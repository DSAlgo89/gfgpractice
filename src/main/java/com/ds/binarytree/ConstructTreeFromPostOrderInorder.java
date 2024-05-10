package com.ds.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostOrderInorder {
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int value)
        {
            data = value;
            left = null;
            right = null;
        }
    }

    static int postIndx = 0;

    private static Node buildTree(int in[], int post[], int n) {
        // Your code here
        postIndx = n - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return buildTreeRec(post, map,0, n - 1);
    }

    private static Node buildTreeRec(int[] post,Map<Integer, Integer> map, int start, int end) {
        if(start > end || postIndx < 0)
            return null;
        System.out.println(postIndx);
        int num = post[postIndx];
        postIndx--;
        int pivot = map.getOrDefault(num, -1);
        Node root = new Node(num);
        root.left = buildTreeRec(post, map, start, pivot - 1);
        root.right = buildTreeRec(post, map, pivot + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
        buildTree(in, post, in.length);
    }
}

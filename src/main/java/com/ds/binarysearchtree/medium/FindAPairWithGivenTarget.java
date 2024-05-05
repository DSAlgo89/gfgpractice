package com.ds.binarysearchtree.medium;

import java.util.HashSet;
import java.util.Set;

public class FindAPairWithGivenTarget {
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

    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        boolean isPresent = isPairPresentRec(root, target, set);
        return isPresent ? 1: 0;
    }

    private boolean isPairPresentRec(Node root, int target, Set<Integer> set) {
        if (root == null)
            return false;
        if (!set.isEmpty() && set.contains(target - root.data))
            return true;
        set.add(root.data);
        return isPairPresentRec(root.left, target, set)
                || isPairPresentRec(root.right, target, set);
    }


    public static void main(String[] args) {

    }
}

package com.ds.binarysearchtree.medium;

import java.util.ArrayList;
import java.util.List;

public class MergeBSTs {
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

    public List<Integer> merge(Node root1, Node root2)
    {
        // Write your code here
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        return merge(list1, list2);
    }

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> list3 = new ArrayList<>();
        int m = list1.size();
        int n = list2.size();

        int i = 0;
        int j = 0;
        while(i < m && j < n) {
            if(list1.get(i) < list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }

        while(i < m) {
            list3.add(list1.get(i));
            i++;
        }

         while(j < n) {
             list3.add(list2.get(j));
             j++;
         }
         return list3;
    }

    private static void inorder(Node root, List<Integer> list) {
        if(root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static void main(String[] args) {

    }
}

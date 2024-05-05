package com.ds.binarysearchtree.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixingBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node correctBST(Node root)
    {
        List<Node> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        List<Node> newNodes = new ArrayList<>(nodes);
        Collections.sort(newNodes, (t1, t2) -> t1.data - t2.data);
        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i) != newNodes.get(i)) {
                swapByValues(nodes.get(i), newNodes.get(i));
                break;
            }
        }
        return root;
    }

    private void swapByValues(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    private void inorderTraversal(Node root, List<Node> inorderNodes) {
        if(root != null) {
            inorderTraversal(root.left, inorderNodes);
            inorderNodes.add(root);
            inorderTraversal(root.right, inorderNodes);
        }
    }

    public static void main(String[] args) {

    }
}

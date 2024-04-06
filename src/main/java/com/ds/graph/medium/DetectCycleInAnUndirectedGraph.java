package com.ds.graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInAnUndirectedGraph {
    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(hasCycle(adj, i, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, -1));
        visited[node] = true;

        while(!queue.isEmpty()) {
            Pair remNode = queue.poll();
            int currentNode = remNode.first;
            int parent = remNode.second;

            ArrayList<Integer> children = adj.get(currentNode);
            for(Integer child: children) {
                if(!visited[child]) {
                    visited[child] = true;
                    queue.add(new Pair(child, currentNode));
                } else if(parent != child)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

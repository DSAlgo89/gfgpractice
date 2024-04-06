package com.ds.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteGraph {
    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        // Code here
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        for(int i = 0; i < V; i++) {
            if(colors[i] == -1) {
                if(!isBipartiteComp(i, adj, colors)) {
                    return false;
                }
            }

        }
        return true;
    }

    private static boolean isBipartiteComp(int node, ArrayList<ArrayList<Integer>> adj, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        colors[node] = 1;
        queue.add(node);

        while(!queue.isEmpty()) {
            Integer remNode = queue.poll();
            ArrayList<Integer> neighbors = adj.get(remNode);
            if(!neighbors.isEmpty()) {
                for(Integer nei: neighbors) {
                    if(colors[nei] == -1) {
                        colors[nei] = 1 - colors[remNode];
                        queue.add(nei);
                    } else if(colors[nei] == colors[remNode])
                        return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}

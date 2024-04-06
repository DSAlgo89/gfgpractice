package com.ds.graph.medium;

import java.util.*;

public class StronglyConnectedComponents {
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //code here
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs1(adj, i, visited, stack);
            }
        }

        Map<Integer, List<Integer>> adj2 = new HashMap<>();

        for(int i = 0; i < V; i++) {
            ArrayList<Integer> neighbors = adj.get(i);
            if(!neighbors.isEmpty()) {
                for(Integer nei: neighbors) {
                    if(!adj2.containsKey(nei)) {
                        adj2.put(nei, new ArrayList<>());
                    }
                    adj2.get(nei).add(i);
                }
            }
        }

        Arrays.fill(visited, false);

        int scc = 0;
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if(!visited[top]) {
                scc++;
                dfs2(adj2, top, visited);
            }
        }

        return scc;
    }

    private static void dfs2(Map<Integer, List<Integer>> adj2, int node, boolean[] visited) {
        visited[node] = true;
        List<Integer> neighbors = adj2.getOrDefault(node, new ArrayList<>());
        if(!neighbors.isEmpty()) {
            for(Integer nei: neighbors) {
                if(!visited[nei]) {
                    dfs2(adj2, nei, visited);
                }
            }
        }
    }


    private static void dfs1(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        ArrayList<Integer> neighbors = adj.get(node);
        if(!neighbors.isEmpty()) {
            for(Integer nei: neighbors) {
                if(!visited[nei]) {
                    dfs1(adj, nei, visited, stack);
                }
            }
        }
        stack.push(node);
    }


    public static void main(String[] args) {

    }
}

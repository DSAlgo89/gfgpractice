package com.ds.graph.medium;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(hasCycle(adj, i, visited, pathVisited))
                    return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        ArrayList<Integer> neighbors = adj.get(node);
        if(!neighbors.isEmpty()) {
            for(Integer nei: neighbors) {
                if(!visited[nei]) {
                    if(hasCycle(adj, nei, visited, pathVisited))
                        return true;
                } else if(pathVisited[nei])
                    return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int V = 4;
        ArrayList<Integer> nei = new ArrayList<>();
        nei.add(1);
        adjList.add(nei);

        nei = new ArrayList<>();
        nei.add(2);
        adjList.add(nei);

        nei = new ArrayList<>();
        nei.add(3);
        adjList.add(nei);

        nei = new ArrayList<>();
        nei.add(3);
        adjList.add(nei);

        boolean ans = isCyclic(V, adjList);

        System.out.println(ans);
    }
}

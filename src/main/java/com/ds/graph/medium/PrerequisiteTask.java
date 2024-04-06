package com.ds.graph.medium;

import java.util.*;

public class PrerequisiteTask {
    public static boolean isPossible(int N,int P, int[][] prerequisites) {
        // Your Code goes here
        int[] inDeg = new int[N];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < P; i++) {
            int source = prerequisites[i][1];
            int target = prerequisites[i][0];

            if(!adjList.containsKey(source))
                adjList.put(source, new ArrayList<>());
            adjList.get(source).add(target);
            inDeg[target]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(inDeg[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty()) {
            Integer rem = queue.poll();
            List<Integer> neighbors = adjList.getOrDefault(rem, new ArrayList<>());
            if(!neighbors.isEmpty()) {
                for(Integer nei: neighbors) {
                    inDeg[nei]--;
                    if(inDeg[nei] == 0) {
                        queue.add(nei);
                        count++;
                    }
                }
            }
        }

        return count == N;
    }


    public static void main(String[] args) {

    }
}

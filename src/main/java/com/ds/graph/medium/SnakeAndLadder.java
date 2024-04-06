package com.ds.graph.medium;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//TBD
public class SnakeAndLadder {

    static int minThrow(int N, int arr[]){
        // code here
        int len = 30;
        int[] pass = new int[len + 1];
        Arrays.fill(pass, -1);
        boolean[] visited = new boolean[len + 1];

        for(int i = 0; i < (N - 1); i+=2) {
            int start = arr[i];
            int end = arr[i + 1];
            pass[start] = end;
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for(int i = 0; i < size; i++) {
                int remItem = queue.poll();
                if(remItem == len)
                    return count;
                for(int dice = remItem + 1; dice <= remItem + 6; dice++) {
                    if(dice > len)
                        break;
                    if(!visited[dice]) {
                       if(pass[dice] == -1) {
                           queue.add(dice);
                       } else {
                           queue.add(pass[dice]);
                       }
                       visited[dice] = true;
                    }
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {
                3, 22, 5, 8, 11, 26, 20, 29,
                17, 4, 19, 7, 27, 1, 21, 9
        };
        int N = 8;
        int ans = minThrow(N, arr);

        System.out.println(ans);
    }
}

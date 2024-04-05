package com.ds.greedy.medium;

import java.util.Arrays;

public class JobSequencingProblem {
    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }


    static int[] JobScheduling(Job arr[], int n) {
        // Your code here
        Arrays.sort(arr, (j1, j2) -> j2.profit - j1.profit);
        int[] jobs = new int[n];
        Arrays.fill(jobs, -1);

        int count = 0;
        int maxProfit = 0;
        for(int i = 0; i < n; i++) {
            Job job = arr[i];
            int deadline = job.deadline - 1;
            for(int j = deadline; j >= 0; j--) {
                if(jobs[j] == -1) {
                    jobs[j] = job.id;
                    count++;
                    maxProfit += job.profit;
                    break;
                }
            }
        }
        return new int[]{count, maxProfit};
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[4];
        jobs[0] = new Job(1,4, 20);
        jobs[1] = new Job(2,1,10);
        jobs[2] = new Job(3,1,40);
        jobs[3] = new Job(4,1,30);

        int[] ans = JobScheduling(jobs, jobs.length);

        System.out.println(Arrays.toString(ans));
    }
}

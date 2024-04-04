package com.ds.hashing.medium;

import java.util.Arrays;

public class TripletSumClosest {
    static int threeSumClosest(int[] array, int target) {
        // code here
        Arrays.sort(array);

        int minDiff = Integer.MAX_VALUE;;
        int closestTarget = 0;
        int n = array.length;

        for(int i = 0; i < n - 1; i++) {
            int start = i + 1;
            int end = n - 1;
            while(start <= end) {
                int sum = array[i] + array[start] + array[end];
                if(sum == target)
                    return sum;
                int currentDiff = Math.abs(target - sum);
                if(minDiff >= currentDiff) {
                    minDiff = currentDiff;
                    closestTarget = Integer.max(closestTarget, sum);
                }
                if(sum > target)
                    end--;
                else
                    start++;
            }
        }
        return closestTarget;
    }

    public static void main(String[] args) {

    }
}

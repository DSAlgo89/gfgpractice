package com.ds.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithZeroSum {
    static int maxLen(int arr[], int n) {
        // Your code here
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        for(int i = 0; i < n; i++) {
            preSum += arr[i];
            if(preSum == 0) {
                maxLen = (i + 1);
            } else {
                if(map.containsKey(preSum)) {
                    maxLen = Integer.max(maxLen, i - map.get(preSum));
                } else {
                    map.put(preSum, i);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {15,-2,2,-8,1,7,10,23};
        int ans = maxLen(nums, nums.length);

        System.out.println(ans);
    }
}

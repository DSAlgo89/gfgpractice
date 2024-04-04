package com.ds.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumDivisibleByK {
    static int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Complete the function
        int presum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxlen = 0;
        int mod = 0;

        for(int i = 0; i < n; i++) {
            presum += a[i];

            mod = ((presum % k) + k) % k;
            if(mod == 0) {
                maxlen = (i + 1);
            } else {
                if(map.containsKey(mod)) {
                    maxlen = Integer.max(maxlen, i - map.get(mod));
                } else {
                    map.put(mod, i);
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 6, 1, 4, 5};
        int k = 3;
        System.out.println(longSubarrWthSumDivByK(nums, nums.length, k));
    }
}

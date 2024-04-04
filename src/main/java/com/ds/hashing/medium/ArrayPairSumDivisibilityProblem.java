package com.ds.hashing.medium;

import java.util.HashSet;
import java.util.Set;

public class ArrayPairSumDivisibilityProblem {
    private static boolean canPair(int[] nums, int k) {
        // Code here
        if(nums.length % 2 != 0)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int r1 = nums[i] % k;
            int r2 = k - r1;
            if(set.contains(r2)) {
                set.remove(r2);
            } else {
                set.add(r1);
            }
        }
        return set.isEmpty();
    }

    public static void main(String[] args) {
        int[] nums = {6, 14, 12, 14};
        int k = 2;

        System.out.println(canPair(nums, k));

        nums = new int[]{4,4,4};
        k = 4;
        System.out.println(canPair(nums, k));
    }
}

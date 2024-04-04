package com.ds.hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class KeyPair {
    static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(set.contains(x - arr[i]))
                return true;
            set.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

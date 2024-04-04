package com.ds.hashing.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindMissingInTheSecondArray {
    private static ArrayList<Integer> findMissing(int a[], int b[], int n, int m)
    {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            set.add(b[i]);
        }

        for(int i = 0;i < n; i++) {
            if(!set.contains(a[i])) {
                result.add(a[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

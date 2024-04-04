package com.ds.hashing.easy;

import java.util.HashMap;
import java.util.Map;


public class NumberOfElementsInIntersection {
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code here
        int intersectionCount = 0;
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(a[i], false);
        }

        for(int i = 0; i < m; i++) {
            if(map.containsKey(b[i]) && !map.get(b[i])) {
                map.put(b[i], true);
                intersectionCount++;
            }
        }
        return intersectionCount;
    }

    public static void main(String[] args) {

    }
}

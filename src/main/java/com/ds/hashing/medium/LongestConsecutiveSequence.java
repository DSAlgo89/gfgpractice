package com.ds.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    static int findLongestConseqSubseq(int arr[], int N) {
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            map.put(arr[i], false);
        }

        int maxlen = 0;
        for(int i = 0; i < N; i++) {
            int k = arr[i];
            int count = 0;
            while(map.containsKey(k) && !map.get(k)) {
                map.put(k, true);
                k++;
                count++;
            }

            k = arr[i] - 1;
            while(map.containsKey(k) && !map.get(k)) {
                map.put(k, true);
                k--;
                count++;
            }

            maxlen = Integer.max(maxlen, count);
        }

        return maxlen;
    }

    public static void main(String[] args) {

    }
}

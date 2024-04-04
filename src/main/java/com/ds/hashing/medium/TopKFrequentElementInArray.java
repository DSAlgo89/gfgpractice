package com.ds.hashing.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElementInArray {
    static class Item implements Comparable<Item>{
        int key;
        int value;

        public Item(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Item item) {
            if(item.value == this.value)
                return item.key - this.key;
            return item.value - this.value;
        }
    }

    private static int[] topK(int[] nums, int k) {
        // Code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Item> pQ = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pQ.add(new Item(entry.getKey(), entry.getValue()));
        }

        int[] result = new int[k];
        int i = 0;
        while(!pQ.isEmpty() && i < k) {
            result[i++] = pQ.poll().key;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}

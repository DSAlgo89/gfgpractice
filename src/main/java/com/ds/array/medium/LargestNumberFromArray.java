package com.ds.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumberFromArray {
    static class NumComparator implements Comparator<String> {

        @Override
        public int compare(String s, String t1) {
            return (t1 + s).compareTo(s + t1);
        }
    }

    private static String printLargest(int n, String[] arr) {
        // code here
        List<String> list = new ArrayList<>();
        for(String num: arr) {
            list.add(num);
        }

        Collections.sort(list, new NumComparator());
        StringBuilder sb = new StringBuilder();
        for(String token: list) {
            sb.append(token);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] nums = {"3", "30", "34", "5", "9"};
        int n = 5;

        System.out.println(printLargest(n, nums));
    }
}

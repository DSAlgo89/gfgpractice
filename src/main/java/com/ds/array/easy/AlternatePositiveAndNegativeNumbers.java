package com.ds.array.easy;

import java.util.ArrayList;
import java.util.List;

public class AlternatePositiveAndNegativeNumbers {
    static void rearrange(int arr[], int n) {
        // code here
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(arr[i] >= 0) {
                positive.add(arr[i]);
            } else {
                negative.add(arr[i]);
            }
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < positive.size() && j < negative.size()) {
            arr[k++] = positive.get(i);
            arr[k++] = negative.get(j);
            i++;
            j++;
        }

        while(i < positive.size()) {
            arr[k++] = positive.get(i);
            i++;
        }

        while(j < negative.size()) {
            arr[k++] = negative.get(j);
            j++;
        }
    }

    public static void main(String[] args) {

    }
}

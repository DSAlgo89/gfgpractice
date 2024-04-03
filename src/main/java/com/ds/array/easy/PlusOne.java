package com.ds.array.easy;

import java.util.ArrayList;
import java.util.Collections;

public class PlusOne {
    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        int carry = 0;
        int size = arr.size();
        int i = size - 1;
        sum = arr.get(i) + 1;
        if(sum > 9) {
            int r = sum % 10;
            carry = sum / 10;
            sum = r;
        }
        result.add(sum);
        i--;

        while(i >= 0) {
            sum = arr.get(i);
            if(carry > 0) {
                sum += carry;
                if(sum > 9) {
                    int r = sum % 10;
                    carry = sum / 10;
                    sum = r;
                } else {
                    carry = 0;
                }
            }
            result.add(sum);
            i--;
        }
        if(carry > 0) {
            result.add(carry);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(9);
        list.add(9);
        System.out.println(increment(list, list.size()));

        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);

        System.out.println(increment(list, list.size()));
    }
}

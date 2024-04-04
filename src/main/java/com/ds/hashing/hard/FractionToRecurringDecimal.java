package com.ds.hashing.hard;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    private static String fractionToDecimal(int numerator, int denominator) {
        // Code here
        StringBuilder ans = new StringBuilder();
        int q = numerator / denominator;
        int r = numerator % denominator;
        ans.append(q);

        if(r == 0)
            return ans.toString();
        ans.append(".");
        Map<Integer, Integer> map = new HashMap<>();
        while(r != 0) {
            if(map.containsKey(r)) {
                int len = map.get(r);
                ans.insert(len, "(");
                ans.append(")");
                break;
            } else {
                map.put(r, ans.length());
                r = r * 10;
                q = r / denominator;
                r = r % denominator;
                ans.append(q);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(14, 3));
        System.out.println(fractionToDecimal(47, 18));
    }
}

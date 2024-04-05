package com.ds.greedy.easy;

public class LargestNumberWithGivenSum {
    static String largestNumber(int n, int sum) {
        // add your code here
        StringBuilder sb = new StringBuilder();
        if(sum == 0) {
            appendZeroes(sb, n);
            return sb.toString();
        }
        if(sum >= 1 && sum <= 9) {
            sb.append(sum);
            appendZeroes(sb, n - 1);
            return sb.toString();
        }

        sb.append(9);
        sum = sum - 9;
        n--;
        while(n > 0 && sum >= 9) {
            sb.append(9);
            sum -= 9;
            n--;
        }

        if(n == 0 && sum > 0)
            return "-1";
        if(sum > 0) {
            sb.append(sum);
            n--;
        }

        if(n > 0)
            appendZeroes(sb, n);
        return sb.toString();
    }

    private static void appendZeroes(StringBuilder sb, int count) {
        while(count-- > 0) {
            sb.append(0);
        }
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(5, 12));
        System.out.println(largestNumber(3, 29));
    }
}

package com.ds.array.easy;

public class ThirdLargestElement {
    static int thirdLargest(int a[], int n) {
        // Your code here
        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i < n; i++) {
            if(a[i] > max1) {
                max2 = max1;
                max1 = a[i];
            } else if(a[i] > max2 && a[i] < max1) {
                max2 = a[i];
            }
        }

        int max3 = 0;
        for(int i = 0; i < n; i++) {
            if(a[i] > max3 && a[i] < max1 && a[i] < max2) {
                max3 = a[i];
            }
        }
        return max3;
    }

    public static void main(String[] args) {

    }
}

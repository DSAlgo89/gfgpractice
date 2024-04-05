package com.ds.greedy.medium;

public class MajorityElement {
    static int majorityElement(int a[], int size) {
        // your code here
        int majIndx = 0;
        int count = 1;

        for(int i = 1; i < size; i++) {
            if(a[i] == a[majIndx]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    majIndx = i;
                    count = 1;
                }
            }
        }

        count = 0;
        for(int i = 0; i < size; i++) {
            if(a[i] == a[majIndx]) {
                count++;
            }
        }

        if(count > size/2)
            return a[majIndx];
        return -1;
    }

    public static void main(String[] args) {

    }
}

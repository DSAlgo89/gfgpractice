package com.ds.greedy.medium;

import java.util.*;

//explanation video - https://www.youtube.com/watch?v=IhIpreSnEhI
public class PoliceAndThieves {
    static int catchThieves(char arr[], int n, int k) {
        // Code here
        List<Integer> pIndices = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'P') {
                pIndices.add(i);
            }
        }

        int count = 0;

        for(int i = 0; i < pIndices.size(); i++) {
            int currentIndx = pIndices.get(i);
            int start = Integer.max(currentIndx - k, 0);
            boolean gotThief = false;
            for(int j = start; j < currentIndx; j++) {
                if(arr[j] == 'T') {
                    gotThief = true;
                    arr[j] = 'C';
                    count++;
                    break;
                }
            }

            if(!gotThief) {
                int end = Integer.min(currentIndx + k, n - 1);
                for(int j = currentIndx + 1; j <= end; j++) {
                    if(arr[j] == 'T') {
                        arr[j] = 'C';
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[] arr = {'P','T','T','P','T'};
        int k = 1;
        int ans = catchThieves(arr, arr.length, k);
        System.out.println(ans);

        arr = new char[]{'T','T','P','P','T','P'};
        k = 2;
        ans = catchThieves(arr, arr.length, k);
        System.out.println(ans);
    }
}

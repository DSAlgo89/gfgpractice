package com.ds.stack;

public class CelebrityProblem {
    static int celebrity(int M[][], int n)
    {
        // code here
        int celebrity = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] == 1) {
                    if(M[j][i] == 0) {
                        celebrity = j;
                    } else {
                        celebrity = -1;
                    }

                }
            }
        }

        if(celebrity == -1)
            return celebrity;

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(M[i][celebrity] == 1) {
                if(M[celebrity][i] == 1)
                    return -1;
                count++;
            }
        }
        if(count == n - 1) {
            return celebrity;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}

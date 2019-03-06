package com.algo.dp;
import java.util.*;


public class RodCutting {
    public int maxProfit(int[] A, int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        int i, j;
        int maxVal = -1;
        for(i = 1; i <= n; i++) {
            for(j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, A[j] + memo[i - j - 1]);
                memo[i] = maxVal;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
          RodCutting obj = new RodCutting();
          int[] A = {3, 9, 8, 2, 5, 9, 1};
          System.out.println(obj.maxProfit(A, 7));
    }
}

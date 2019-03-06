package com.algo.dp;
import java.util.*;

public class KnapSack {
    public int maxValue(int W, int[] value, int[] weight, int N) {
        int i, w;
        int[][] memo = new int[N + 1][W + 1];

        for(i = 0; i <= N; i++) {
            for(w = 0; w <= W; w++) {
                if(i == 0 || w == 0) {
                    memo[i][w] = 0;
                }
                else if(weight[i - 1] <= w) {
                    memo[i][w] = Math.max(value[i - 1] + memo[i - 1][w - weight[i - 1]], memo[i - 1][w]);
                }
                else {
                    memo[i][w] = memo[i - 1][w];
                }
            }
        }
        return memo[N][W];
    }

    public static void main(String[] args) {
        KnapSack obj = new KnapSack();
        int[] value = {1, 2, 3};
        int[] weight = {1, 2, 3};
        int W = 2;
        System.out.println(obj.maxValue(W, value, weight, 3));
    }
}

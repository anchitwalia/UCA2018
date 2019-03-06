package com.algo.dp;
import java.util.*;

public class TripleStep {
    public long countWaysDP(int n) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;

        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        TripleStep obj = new TripleStep();
        System.out.println(obj.countWaysDP(1));
        System.out.println(obj.countWaysDP(2));
        System.out.println(obj.countWaysDP(3));
        System.out.println(obj.countWaysDP(4));
        System.out.println(obj.countWaysDP(5));
        System.out.println(obj.countWaysDP(28));
    }
}

package com.algo.dp;
import java.util.*;


public class TileOrientation {
    public long countOrientation(int n) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;

        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
    public static void main(String[] args) {
          TileOrientation obj = new TileOrientation();
          System.out.println(obj.countOrientation(1));
          System.out.println(obj.countOrientation(2));
          System.out.println(obj.countOrientation(3));
          System.out.println(obj.countOrientation(4));
          System.out.println(obj.countOrientation(5));
          System.out.println(obj.countOrientation(30));
    }
}

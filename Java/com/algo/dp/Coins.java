package com.algo.dp;
import java.util.*;

/* denom is array of coin denominations.
   n is total money needed.
   m is no of denomiantions or denom.length.
*/

public class Coins {
    public int denominationCount(int[] denom, int n ,int m) {
        int[][] memo = new int[n + 1][m];
        int x, y;
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < m; j++) {
                    if(i == 0) {
                        memo[i][j] = 1;
                    }
                    else {
                        if(i - denom[j] >= 0) {
                            x = memo[i - denom[j]][j];
                        }
                        else  x = 0;
                        if(j >= 1) {
                            y = memo[i][j - 1];
                        }
                        else y = 0;
                        memo[i][j] = x + y;
                    }
            }
        }
        return memo[n][m - 1];
    }
    public static void main(String[] args) {
          Coins obj = new Coins();
          int[] denom = {1, 2, 3};
          int n = 100;
          int m = denom.length;
          System.out.println(obj.denominationCount(denom, n, m));
    }
}

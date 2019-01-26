package com.algo.arrays;

public class MaxSumContiguousSubArray {
    public int maxSubArray(final List<Integer> A) {
        int x = A.size();
        int y = A.get(0);
        int sum = A.get(0);
        for(int i = 1; i < x; i++) {
            y = Math.max(A.get(i), A.get(i) + y);
            sum = Math.max(sum, y);
        }
        return sum;
    }
}

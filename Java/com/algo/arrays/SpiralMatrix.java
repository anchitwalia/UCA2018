package com.algo.arrays;

public class SpiralMatrix {
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int top = 0;
        int bottom = A - 1;
        int left = 0;
        int right = A - 1;
        int N = 1;
        for(int i=0;i<A;i++)
        {
            result.add(new ArrayList<Integer>());
            for(int j=0;j<A;j++)
            {
                result.get(i).add(0);
            }
        }
        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                result.get(top).set(i, N);
                N++;
            }
            top++;
            if(top > bottom) { break; }
            for(int i = top; i<= bottom; i++) {
                result.get(i).set(right, N);
                N++;
            }
            right--;
            for(int i = right; i>= left; i--) {
                result.get(bottom).set(i, N);
                N++;
            }
            bottom--;
            if(right < left) { break; }
            for(int i = bottom; i>= top; i--) {
                result.get(i).set(left, N);
                N++;
            }
            left++;
        }
        return result;
    }
}

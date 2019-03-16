//package com.algo.arrays;
import java.util.*;

public class MaximumRectangle {
    class Node {
        public int area;
        public int[] start;
        public int[] end;
        public Node(int area, int si, int sj, int ei, int ej) {
            this.area = area;
            start = new int[2];
            end = new int[2];
            this.start[0] = si;
            this.start[1] = sj;
            this.end[0] = ei;
            this.end[1] = ej;
        }
    }

    class theComparator implements Comparator<Node> {
        public int compare(Node A, Node B) {
                return  A.area - B.area;
        }
    }

    public void maxArea(int[][] A) {
        int i, j;
        int m = A.length;
        int n = A[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new theComparator());
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                if(A[i][j] == 1) {
                    Node temp = check(A, i, j, m, n);
                    pq.add(temp);
                }
            }
        }
        Node result = pq.peek();
        System.out.println("Start : "+"{"+result.start[0]+","+result.start[1]+"}");
        System.out.println("End : "+"{"+result.end[0]+","+result.end[1]+"}");
    }

    public Node check(int[][] A, int i, int j, int m, int n) {
        int area, si, sj, ei, ej;
        int mxr = 0, mxc = 0;
        int temp = 0;
        int x, y;
        si = i;
        sj = j;
        for(x = i; x < m; x++) {
            if(A[x][j] == 0) break;
            for(y = j; y < n; y++) {
                if(A[x][y] == 1) {
                    temp++;
                }
                else {
                    break;
                }
            }
            mxr = Math.min(mxr, temp);
        }
        ei = x;
        ej = mxr;
        area = (ei - si)*(ej - sj);
        Node temp1 = new Node(area, si, sj, ei, ej);
        return temp1;
    }

    public static void main(String[] args) {
        MaximumRectangle obj = new MaximumRectangle();
        int[][] A = {{0, 0, 1, 1, 1},
                     {1, 1, 0, 0, 0},
                     {0, 1, 1, 1, 0},
                     {1, 1, 1, 1, 0}};

        obj.maxArea(A);
    }
}

package com.algo.dp;
import java.util.*;
/* Find the largest rectangle with 1's in a Binary 2D Array. Print the Rectangle.

int M5[][] = {{1, 1, 1, 0, 0},
							{1, 1, 1, 0, 0},
							{1, 1, 1, 0, 0},
							{0, 1, 1, 1, 1},
							{0, 1, 1, 1, 1},
							{0, 1, 1, 1, 1}};
    Output
    Start : {0, 1} & End : {5, 2}
    1 1
    1 1
    1 1
    1 1
    1 1
    1 1
    Area = 12
*/

public class MaximumRectangleArea {
		public int maximalRectangle(int[][] A, int M, int N) {
		    if (M == 0 || N == 0)  {
							System.out.println("Array Empty!");
	            return 0;
	      }
		    int[][] dp = new int[M][N];
		    int maxRec = 0;
				int maxwid = 1;
				int maxrow = 1;
				int mi = 0, mj = 0;
	      for (int i = 0; i < dp.length; i++) {
	          for (int j = 0; j < dp[0].length; j++) {
	              int num = A[i][j];
	              if (j == 0) {
	                  dp[i][j] = num > 0 ? 1 : 0;
	              }
	              else {
	                  dp[i][j] = num > 0 ? dp[i][j - 1] + 1 : 0;
								}
	              int row = i, width = dp[i][j];
	              while (row >= 0 && dp[row][j] > 0) {
	                   width = Math.min(width, dp[row][j]);
										 if(maxRec < width * (i - row + 1)) {
											 		maxwid = width;
													maxrow = i - row + 1;
													maxRec = maxwid * (maxrow);
													mi = row;
													mj = j;
										 }
	                   row--;
	              }
	          }
	      }
				printArray(A, mi, mj - maxwid + 1, mi + maxrow - 1, mj);
	      return maxRec;
		}

		private void printArray(int[][] A, int x1, int y1, int x2, int y2) {
				if(x1 == 0 && x2 == 0 && y1 == 0 && y2 == 0) {
						System.out.println("No Rectangle Found !");
						return;
				}

				System.out.println("Start : {"+x1 +", "+ y1+"} & End : {"+(x2) +", "+(y2)+"} ");

				for(int i = x1; i <= x2; i++) {
						for(int j = y1; j <= y2; j++) {
								System.out.print(A[i][j]+" ");
						}
						System.out.println();
				}
		}
 }

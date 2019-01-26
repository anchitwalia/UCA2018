class NoOfIslands {
    private static void areaSearch(int[][] A, boolean[][] MARKED ,int n, int m, int x, int y) {
        int row[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int col[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        MARKED[x][y] = true;
        for(int i = 0; i < 8; i++) {
            int newx = x + row[i];
            int newy = y + col[i];
            if(newx >= 0 && newx < n && newy >=0 && newy < m && A[newx][newy] == 1 && MARKED[newx][newy] == false){
                areaSearch(A, MARKED, n, m, newx, newy);
            }
        }

    }

    public static int findIsland(int[][] A,int n,int m) {
        boolean MARKED[][] = new boolean[n][m];
        int COUNT = 0;
        int i, j;
        for(i = 0; i < n; i++) {
            for(j = 0; j < m; j++) {
                if(A[i][j] == 1 && MARKED[i][j] == false) {
                    areaSearch(A, MARKED, n, m, i, j);
                    COUNT++;
                }
            }
        }
        return COUNT;
    }
}

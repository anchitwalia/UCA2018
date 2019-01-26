public class BlackSheep {
    public void findSize(ArrayList < String > A, boolean[][] visited, int i, int j, int r, int c) {
        visited[i][j] = true;
        int newi, newj;
        int dir[][] = {{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }};
        for (int d = 0; d < 4; d++) {
            newi = i + dir[d][i];
            newj = j + dir[d][j];
            if (newi >= 0 && newi < r && newj >= 0 && newj < c && A.get(newi).charAt(newj) == 'X' && visited[newi][newj] == false) {
                findSize(A, visited, newi, newj, r, c);
            }
        }
    }
    public int black(ArrayList < String > A) {
        int r = A.size();
        int c = A.get(0).length();
        int i, j, count = 0;
        boolean visited[][] = new boolean[r][c];
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                visited[i][j] = false;
            }
        }
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (visited[i][j] == false && A.get(i).charAt(j) == 'X') {
                    count++;
                    findSize(A, visited, i, j, r, c);
                }
            }
        }
        return count;
    }
}

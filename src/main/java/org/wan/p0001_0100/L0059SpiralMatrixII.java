package org.wan.p0001_0100;

public class L0059SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] dr = new int[] {0, 1, 0, -1};
        int[] dc = new int[] {1, 0, -1, 0};
        int total = n * n;
        int i = 0, j = 0;
        int k = 1;
        int idx = 0;
        while (total > 0) {
            res[i][j] = k;
            k += 1;
            total -= 1;
            if (total == 0) {
                break;
            }
            int row = i + dr[idx];
            int col = j + dc[idx];
            while (row < 0 || col < 0 || row >= n || col >= n || res[row][col] != 0) {
                idx += 1;
                idx %= 4;
                row = i + dr[idx];
                col = j + dc[idx];
            }
            i = row;
            j = col;
        }
        return res;
    }

    static void main() {
        L0059SpiralMatrixII s = new L0059SpiralMatrixII();
        s.generateMatrix(3);
    }
}

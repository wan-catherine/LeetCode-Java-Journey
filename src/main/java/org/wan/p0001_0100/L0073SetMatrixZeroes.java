package org.wan.p0001_0100;

public class L0073SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m  = matrix.length;
        int n = matrix[0].length;
        boolean zero = matrix[0][0] == 0;
        boolean mz = false;
        boolean nz = false;
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                mz = true;
                break;
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                nz = true;
                break;
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    break;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    break;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (zero) {
            for (int i = 1; i < m; i++) {
                matrix[i][0] = 0;
            }
            for (int j = 1; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (mz) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (nz) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    static void main() {
        L0073SetMatrixZeroes s = new L0073SetMatrixZeroes();
        s.setZeroes(new int[][]{{1,1,1}, {1,0,1}, {1,1,1}});
    }
}

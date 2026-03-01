package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * the key point is how to change direction
 * also using two int[] to define direction
 */
public class L0054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int idx = 0;
        int i = 0, j = 0;
        while (total > 0) {
            result.add(matrix[i][j]);
            visited[i][j] = true;
            int row = i + dr[idx];
            int col = j + dc[idx];
            if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
                idx++;
                idx %= 4;
            }
            i = i  + dr[idx];
            j = j + dc[idx];
            total -= 1;
        }
        return result;
    }

    static void main() {
        L0054SpiralMatrix s = new L0054SpiralMatrix();
        System.out.print(s.spiralOrder(new int[][]{ new int[] {1,2,3,4}, new int[] {5,6,7,8}, new int[] {9,10,11,12}}));
    }
}

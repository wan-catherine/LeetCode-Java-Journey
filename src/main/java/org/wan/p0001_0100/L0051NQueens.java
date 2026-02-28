package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0051NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(0, board, result);
        return result;
    }

    private void dfs(int i, char[][] curLi, List<List<String>> result) {
        if (i == curLi.length) {
            List<String> list = Arrays.stream(curLi).map(String::new).toList();
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < curLi.length; j++) {
            if (check(i, j, curLi)) {
                curLi[i][j] = 'Q';
                dfs(i+1, curLi, result);
                curLi[i][j] = '.';
            }
        }
    }

    private boolean check(int i, int j,  char[][] curLi) {
        for (int r = 0; r < curLi.length; r++) {
            if (r == i) {
                continue;
            }
            if (curLi[r][j] == 'Q') {
                return false;
            }
        }

        for (int c = 0; c < curLi.length; c++) {
            if (c == j) {
                continue;
            }
            if  (curLi[i][c] == 'Q') {
                return false;
            }
        }

        int[][] directions = new int[][]{{-1, 1}, {1, 1}, {-1, -1}, {1, -1}};
        for (int k = 0; k < directions.length; k++) {
            int p = directions[k][0];
            int q = directions[k][1];
            int r = i;
            int c = j;
            while (r + p >= 0 && c + q >= 0 && r + p < curLi.length && c + q < curLi.length) {
                if (curLi[r+p][c+q] == 'Q') {
                    return false;
                }
                r += p;
                c += q;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L0051NQueens l = new L0051NQueens();
        System.out.println(l.solveNQueens(4));
    }
}

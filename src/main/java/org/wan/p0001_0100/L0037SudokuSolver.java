package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.List;

public class L0037SudokuSolver {
    public void solveSudoku(char[][] board) {
        List<List<Integer>> empty = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    empty.add(List.of(i, j));
                }
            }
        }

        dfs(0, empty, board);
    }

    private boolean dfs(int idx, List<List<Integer>> empty, char[][] board) {
        if (idx == empty.size()) {
            return true;
        }
        boolean[] flags = new boolean[9];
        int row = empty.get(idx).get(0);
        int col = empty.get(idx).get(1);

        for (int c = 0; c < 9; c++) {
            if (board[row][c] != '.') {
                flags[board[row][c] - '1'] = true;
            }
        }

        for (int r = 0; r < 9; r++) {
            if (board[r][col] != '.') {
                flags[board[r][col] - '1'] = true;
            }
        }

        for (int r = (row / 3) * 3; r < (row / 3) * 3 + 3; r++) {
            for (int c = (col / 3) * 3; c < (col / 3) * 3 + 3; c++) {
                if (board[r][c] != '.') {
                    flags[board[r][c] - '1'] = true;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (flags[i]) {
                continue;
            }
            board[row][col] = (char) (i + '1');
            if (dfs(idx + 1, empty, board)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }
}

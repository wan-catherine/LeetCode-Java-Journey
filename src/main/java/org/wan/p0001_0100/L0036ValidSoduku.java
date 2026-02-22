package org.wan.p0001_0100;

public class L0036ValidSoduku {
    public boolean isValidSudoku(char[][] board) {
        boolean row = checkRows(board);
        boolean col = checkCols(board);
        boolean sub = checkSubBoxes(board);
        return row && col && sub;
    }

    private boolean checkRows(char[][] board) {
        for (char[] row : board) {
            boolean[] flag = new boolean[9];
            for (char c : row) {
                if (c == '.') {
                    continue;
                }
                if (flag[c - '1']) {
                    return false;
                }
                flag[c - '1'] = true;
            }
        }
        return true;
    }

    private boolean checkCols(char[][] board) {
        for (int col = 0; col < 9; col++) {
            boolean[] flag = new boolean[9];
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') {
                    continue;
                } else if (flag[board[row][col] - '1']) {
                    return false;
                }
                flag[board[row][col] - '1'] = true;
            }
        }
        return true;
    }

    private boolean checkSubBoxes(char[][] board) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                boolean[] flag = new boolean[9];
                for (int x = row; x < row + 3; x++) {
                    for (int y = col; y < col + 3; y++) {
                        if (board[x][y] == '.') {
                            continue;
                        }  else if (flag[board[x][y] - '1']) {
                            return false;
                        }
                        flag[board[x][y] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}

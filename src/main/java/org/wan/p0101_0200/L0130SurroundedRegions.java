package org.wan.p0101_0200;

import java.util.ArrayList;
import java.util.List;

public class L0130SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] dp = new boolean[n][m];
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        int[] dr = new int[] {1,0,-1,0};
        int[] dc = new int[] {0,-1,0,1};
        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O') {
                rows.add(0);
                cols.add(c);
            }
            if (board[n - 1][c] == 'O') {
                rows.add(n - 1);
                cols.add(c);
            }
        }
        for (int r = 1; r < n - 1; r++) {
            if (board[r][0] == 'O') {
                rows.add(r);
                cols.add(0);
            }
            if (board[r][m - 1] == 'O') {
                rows.add(r);
                cols.add(m - 1);
            }
        }
        for (int i = 0; i <= rows.size() - 1; i++) {
            dfs(rows.get(i), cols.get(i), dp, dr, dc, board);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X' || dp[i][j]) {
                    continue;
                }
                board[i][j] = 'X';
            }
        }
    }

    private void dfs(int row, int col, boolean[][] dp,  int[] dr, int[] dc,  char[][] board) {
        dp[row][col] = true;
        for (int k = 0; k < 4; k++) {
            int r = row + dr[k];
            int c = col + dc[k];
            if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 'X' || dp[r][c]) continue;
            dp[r][c] = true;
            dfs(r, c, dp, dr, dc, board);
        }
    }

}

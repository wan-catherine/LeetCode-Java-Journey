package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.List;

public class L0079WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    list.add(List.of(i, j));
                }
            }
        }
        for (List<Integer> l : list) {
            if (dfs(board, new boolean[m][n], word, l.getFirst(), l.getLast(), 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (word.charAt(index) != board[row][col]) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[row][col] = true;
        int[] dr = {0, 1, -1, 0};
        int[] dc = {1, 0, 0, -1};
        for (int i = 0; i < 4; i++) {
            int x = row + dr[i];
            int y = col + dc[i];
            if (x < 0 || y < 0  || x >= board.length || y >= board[0].length || visited[x][y]) {
                continue;
            }
            if (dfs(board, visited, word, x, y, index + 1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    static void main() {
        L0079WordSearch wordSearch = new L0079WordSearch();
        System.out.println(wordSearch.exist(new char[][]{{'a'}}, "a"));
    }
}

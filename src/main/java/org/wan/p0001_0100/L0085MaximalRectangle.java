package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.List;

public class L0085MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[] tmp = new int[n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    tmp[j + 1] += 1;
                } else {
                    tmp[j + 1] = 0;
                }
            }

            List<Integer> stack = new ArrayList<>();
            for (int k = 0; k < tmp.length; k++) {
                while (!stack.isEmpty() && tmp[stack.getLast()] > tmp[k]) {
                    int cur = stack.removeLast();
                    res = Math.max(res, tmp[cur] * (k - stack.getLast() - 1));
                }
                stack.add(k);
            }
        }
        return res;
    }

    static void main() {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new L0085MaximalRectangle().maximalRectangle(matrix));
    }
}

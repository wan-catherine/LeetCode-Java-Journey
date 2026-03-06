package org.wan.p0001_0100;

public class L0074SearchA2DMatrix {
    public boolean searchMatrix_(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1;
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (target == matrix[mid][0]) {
                return true;
            }
            if (target < matrix[mid][0]) {
                down = mid - 1;
            } else {
                up = mid + 1 ;
            }
        }
        if (down < 0) return false;

        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[down][mid]) {
                return true;
            }
            if (target < matrix[down][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n  - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];
            if (target == midValue) {
                return true;
            } else if (target < midValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    static void main() {
        L0074SearchA2DMatrix sol = new L0074SearchA2DMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(sol.searchMatrix(matrix, 3));
    }
}

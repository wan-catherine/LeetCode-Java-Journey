package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;

public class L0057InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;

        if (len == 0 || newInterval[1] < intervals[0][0]) {
            int[][] result = new int[len+1][2];
            result[0] = newInterval;
            System.arraycopy(intervals, 0, result, 1, len);
            return result;
        }

        ArrayList<int[]> left = new ArrayList<>();
        int start = newInterval[0];
        for (int i = 0; i < len; i++) {
            if (intervals[i][1] < newInterval[0]) {
                left.add(intervals[i]);
            } else {
                start = Math.min(intervals[i][0], newInterval[0]);
                break;
            }
        }
        ArrayList<int[]> right = new ArrayList<>();
        int end = newInterval[1];
        for (int i = len-1; i >= 0; i--) {
            if (intervals[i][0] > newInterval[1]) {
                right.add(intervals[i]);
            } else {
                end =  Math.max(intervals[i][1], newInterval[1]);
                break;
            }
        }
        int[][] result = new int[left.size() + 1 + right.size()][2];
        int idx = 0;
        for (int[] arr : left) {
            result[idx++] = arr;
        }
        result[idx++] = new int[]{start, end};
        for (int i = right.size()-1; i >= 0; i--) {
            result[idx++] = right.get(i);
        }
        return result;
    }

    static void main() {
        L0057InsertInterval l0057InsertInterval = new L0057InsertInterval();
        System.out.print(Arrays.deepToString(l0057InsertInterval.insert(new int[][]{{1, 5}}, new int[]{6, 8})));

    }
}

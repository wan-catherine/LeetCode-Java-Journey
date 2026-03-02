package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class L0056MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int len = intervals.length;
        ArrayList<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if (s <= end) {
                end = Math.max(end, e);
            } else {
                result.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge_fast(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;

        // 1. 优化排序：使用更直接的 lambda 比较
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. 预分配结果数组，避免 ArrayList 动态扩容
        int[][] res = new int[n][2];
        int idx = 0;

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= end) {
                // 合并区间
                end = Math.max(end, intervals[i][1]);
            } else {
                // 存入结果，并开启新区间
                res[idx++] = new int[]{start, end};
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // 3. 处理最后一组区间（移出循环外）
        res[idx++] = new int[]{start, end};

        // 4. 截断数组返回
        return Arrays.copyOf(res, idx);
    }
}

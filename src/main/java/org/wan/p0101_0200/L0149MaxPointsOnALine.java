package org.wan.p0101_0200;

import java.util.HashMap;
import java.util.Map;

public class L0149MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int max = 0;

        for (int i = 0; i < n; i++) {
            // 每次固定点 i，开一个新 map，这样不用算截距 b，只要斜率一样且过同一点 i，必在同一直线
            Map<String, Integer> map = new HashMap<>();
            int localMax = 0;
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int gcd = gcd(dx, dy);
                String key = (dx / gcd) + "_" + (dy / gcd); // 约分后的唯一斜率标识

                map.put(key, map.getOrDefault(key, 0) + 1);
                localMax = Math.max(localMax, map.get(key));
            }
            max = Math.max(max, localMax + 1); // +1 是加上点 i 自己
        }
        return max;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.List;

public class L0084LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len =  heights.length;
        int[] rights = new int[len];
        int[] lefts = new int[len];
        //very import to set the initialized value
        for (int i = 0; i < len; i++) {
            lefts[i] = -1;
            rights[i] = len;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            while(!list.isEmpty() && heights[list.getLast()] >= heights[i]) {
                Integer idx = list.removeLast();
                rights[idx] = i;
            }
            if (!list.isEmpty()) {
                lefts[i] = list.getLast();
            }
            list.add(i);
        }
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            cur = heights[i] * (rights[i] - lefts[i] - 1);
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    static void main() {
        L0084LargestRectangleInHistogram l = new L0084LargestRectangleInHistogram();
        System.out.println(l.largestRectangleArea(new int[]{2, 3}));
    }
}

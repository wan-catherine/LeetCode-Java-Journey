package org.wan.p0001_0100;

import java.util.ArrayList;

public class L0042TrappingRainWater {
    public int trap_(int[] height) {
        record Item(int value, int index) {}
        int len = height.length;
        ArrayList<Item> list = new ArrayList<>();
        int res = 0;
        int low = 0;
        for (int i = 0; i < len; i++) {
            while (!list.isEmpty() && list.getLast().value <= height[i]) {
                if (list.getLast().value == height[i] || list.size() == 1) {
                    list.removeLast();
                    continue;
                }
                int last = list.removeLast().value;
                int lastSecond = list.getLast().value;
                int lastSecondIndex = list.getLast().index;
                low = Math.max(low, last);
                res += (Math.min(lastSecond, height[i]) - low) * (i - lastSecondIndex -1);
            }
            list.add(new Item(height[i], i));
            low = 0; // critical to reset the low.
        }
        return res;
    }

    public int trap(int[] height) {
        int len = height.length;
        ArrayList<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < len; i++) {
            while (!list.isEmpty() && height[list.getLast()] <= height[i]) {
                if (height[list.getLast()] == height[i] || list.size() == 1) {
                    list.removeLast();
                    continue;
                }
                int middle = height[list.removeLast()];
                int leftIndex = list.getLast();
                res += (Math.min(height[leftIndex], height[i]) - middle) * (i - leftIndex -1);
            }
            list.add(i);
        }
        return res;
    }
}

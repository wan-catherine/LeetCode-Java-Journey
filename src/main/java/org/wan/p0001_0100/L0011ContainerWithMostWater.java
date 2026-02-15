package org.wan.p0001_0100;


import static java.lang.Math.min;
import static java.lang.Math.max;


public class L0011ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int h = min(height[l], height[r]);
            ans = max(ans, h * (r - l));
            if (height[l] <  height[r] ) {
                l += 1;
            } else {
                r -= 1;
            }
        }
        return ans;
    }
}

package org.wan.p0001_0100;

import java.util.Arrays;

public class L0016ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = length - 1;
            while (l < r) {
                int current = nums[i] + nums[l] + nums[r];
                if (current == target) {
                    return target;
                } else if (current > target) {
                    r -= 1;
                } else {
                    l += 1;
                }
                // in java, Math.abs(-2147483648) == -2147483648, because of integer overflow
                if (Math.abs(target - current) < Math.abs(target - res)) {
                    res = current;
                }
            }
        }
        return res;
    }
}

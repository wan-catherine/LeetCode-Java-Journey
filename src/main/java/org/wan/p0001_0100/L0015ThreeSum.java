package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0015ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r -= 1;
                } else if (sum < 0) {
                    l += 1;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    int pre = nums[l];
                    while (l + 1 < r && nums[l + 1] == pre)  {
                        l += 1;
                    }
                    l += 1;
                }
            }
        }
        return res;
    }
}

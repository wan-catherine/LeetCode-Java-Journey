package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L0018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = len - 1;
                while (l < r) {
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum < target) {
                        l += 1;
                    } else if (sum > target) {
                        r -= 1;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l += 1;
                    }
                }
            }
        }
        return res;
    }
}

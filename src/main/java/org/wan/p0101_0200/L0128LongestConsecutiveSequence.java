package org.wan.p0101_0200;

import java.util.HashSet;

public class L0128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int res = 0;
        for(int num : set) {
            if (set.contains(num - 1)) continue;
            int val = num;
            int count = 1;
            while (set.contains(val + 1)) {
                val += 1;
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}

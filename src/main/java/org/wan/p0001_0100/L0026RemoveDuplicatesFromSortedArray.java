package org.wan.p0001_0100;

public class L0026RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int f = 0, s = 1;
        while (s < len) {
            if (nums[f] == nums[s]) {
                s += 1;
                continue;
            }
            f += 1;
            nums[f] = nums[s];
            s += 1;
        }
        return f + 1;
    }
}

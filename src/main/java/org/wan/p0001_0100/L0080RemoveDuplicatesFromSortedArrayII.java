package org.wan.p0001_0100;

public class L0080RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int cur = 1;
        int curValue = nums[0];
        int index = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != curValue) {
                curValue = nums[i];
                cur = 1;
                nums[index++] = curValue;
                continue;
            }
            if (nums[i] == curValue) {
                if (cur + 1 <= 2) {
                    nums[index++] = curValue;
                    cur += 1;
                }
            }
        }
        return index;
    }
}

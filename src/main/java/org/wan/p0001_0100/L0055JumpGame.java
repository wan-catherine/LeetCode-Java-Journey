package org.wan.p0001_0100;

public class L0055JumpGame {
    public boolean canJump(int[] nums) {
        int len =  nums.length;
        if (len < 2) {
            return true;
        }
        int cur = 0;
        for (int i = 0; i < len - 1; i++) {
            if (i + nums[i] > cur) {
                cur = i + nums[i];
                if (cur >= len - 1) {
                    return true;
                }
            }
            if (i == cur && nums[i] == 0) {
                return false;
            }
        }
        return false;
    }
}

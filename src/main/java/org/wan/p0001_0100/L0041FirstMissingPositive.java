package org.wan.p0001_0100;

public class L0041FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len =  nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 0;
                continue;
            }
            while(nums[i] > 0 && nums[i] <= len) {
                if (nums[nums[i] - 1] == nums[i]) {
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            return i + 1;
        }
        return len + 1;
    }
}

package org.wan.p0001_0100;

public class L0031NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i -= 1;
        }
        if (i == len - 1) {
            int v = nums[i - 1];
            nums[i - 1] = nums[i];
            nums[i] = v;
            return;
        }
        if (i > 0) {
            int j = i - 1;
            for (int k = len - 1; k > j; k--) {
                if (nums[k] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = tmp;
                    break;
                }
            }
        }
        int left = i, right = len - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

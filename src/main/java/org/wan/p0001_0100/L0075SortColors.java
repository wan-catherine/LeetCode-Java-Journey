package org.wan.p0001_0100;

public class L0075SortColors {
    public void sortColors(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int low, int high) {
        if (low >= high) return;
        int i = low + 1;
        int p = nums[low];
        int l = low, r = high;
        while (i <= r) {
            if (nums[i] == p) {
                i += 1;
            } else if (nums[i] < p) {
                int tmp = nums[i];
                nums[i] = nums[l];
                nums[l] = tmp;
                i += 1;
                l += 1;
            } else {
                int tmp = nums[i];
                nums[i] = nums[r];
                nums[r] = tmp;
                r -= 1;
            }
        }
        helper(nums, low, l - 1);
        helper(nums, r + 1, high);
    }
}

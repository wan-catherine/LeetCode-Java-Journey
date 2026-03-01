package org.wan.p0001_0100;

public class L0053MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len =  nums.length;
        boolean hasPositive = false;
        int result = nums[0];
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                hasPositive = true;
                break;
            }
            result = Math.max(result, nums[i]);
        }
        if (!hasPositive) {
            return result;
        }
        int res = 0;
        int cur = 0;
        for  (int i = 0; i < len; i++) {
            cur += nums[i];
            if (cur > res) {
                res = cur;
                continue;
            }
            if (cur <= 0) {
                cur = 0;
            }
        }
        return res;
    }

    static void main() {
        L0053MaximumSubarray obj = new L0053MaximumSubarray();
        System.out.print(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}

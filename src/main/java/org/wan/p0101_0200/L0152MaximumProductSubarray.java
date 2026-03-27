package org.wan.p0101_0200;


public class L0152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int ans = Math.max(min, max);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                min = 0;
                max = 0;
            } else {
                int v1 = nums[i] * min;
                int v2 = nums[i] * max;
                min = Math.min(Math.min(v1, v2), nums[i]);
                max = Math.max(Math.max(v1, v2), nums[i]);
            }
            ans = Math.max(ans, Math.max(min, max));
        }
        return ans;
    }

    static void main() {
        L0152MaximumProductSubarray sol = new L0152MaximumProductSubarray();
        System.out.println(sol.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(sol.maxProduct(new int[]{-2,0,-1}));
        System.out.println(sol.maxProduct(new int[]{-2}));
        System.out.println(sol.maxProduct(new int[]{0,2}));
        System.out.println(sol.maxProduct(new int[]{-2,0}));
    }
}

package org.wan.p0101_0200;

/*
x ^ x = 0
x ^ 0 = x
 */
public class L0136SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}

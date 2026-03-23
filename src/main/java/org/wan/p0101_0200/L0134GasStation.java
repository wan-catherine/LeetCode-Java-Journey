package org.wan.p0101_0200;

import java.util.Arrays;

public class L0134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len =  gas.length;
        int[] diff = new int[len];
        for (int i = 0; i < len; i++) {
            diff[i] = gas[i] - cost[i];
        }
        if (Arrays.stream(diff).sum() < 0) {
            return -1;
        }
        int cur = 0;
        int left = 0, right = 0;
        int count = 0;
        while (count < len) {
            cur += diff[right];
            if (cur < 0) {
                while (left < right && cur < 0) {
                    cur -= diff[left ];
                    left++;
                    left %= len;
                    count -= 1;
                }
                if (left == right) {
                    right++;
                    left++;
                    left %= len;
                    right %= len;
                    cur = 0;
                    count = 0;
                }
            } else{
                right += 1;
                right %= len;
                count += 1;
            }
        }
        return left;
    }
}

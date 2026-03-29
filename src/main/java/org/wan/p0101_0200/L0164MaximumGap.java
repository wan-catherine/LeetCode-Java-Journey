package org.wan.p0101_0200;

import java.util.Arrays;

public class L0164MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        if (max == min) return 0;

        // 1. 计算每个桶的跨度（至少为 1）
        int gap = Math.max(1, (max - min) / (n - 1));
        int bucketNum = (max - min) / gap + 1;

        // 2. 存储每个桶的最值
        int[] bucketMin = new int[bucketNum];
        int[] bucketMax = new int[bucketNum];
        boolean[] hasNum = new boolean[bucketNum];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // 3. 将数字放入对应的桶
        for (int num : nums) {
            int idx = (num - min) / gap;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            hasNum[idx] = true;
        }

        // 4. 计算最大的桶间间距
        int maxGap = 0;
        int prevMax = min; // 第一个桶肯定有 min
        for (int i = 0; i < bucketNum; i++) {
            if (!hasNum[i]) continue;
            // 当前桶的最小值 - 前一个非空桶的最大值
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }
}

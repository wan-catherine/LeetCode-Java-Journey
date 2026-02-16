package org.wan.p0001_0100;

public class L0004MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if (len1 == 0) {
            return (nums2[(len2 - 1) / 2] + nums2[len2 / 2]) / 2.0;
        }

        int len = len1 + len2;

        // here is the number of partition
        // [1, 2] which has 3 partition
        // 0: | 1, 2
        // 1: 1 | 2
        // 2: 1, 2 |

        int l = 0, r = len1;

        while (l <= r) {
            int p1 = (r - l) / 2 + l;  // int p1 = (l + r) >>> 1;
            int p2 = (len + 1) / 2 - p1;

            double l1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
            double l2 =  p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1];
            double r1 = p1 == len1 ? Integer.MAX_VALUE : nums1[p1];
            double r2 =  p2 == len2 ? Integer.MAX_VALUE : nums2[p2];

            if (l1 > r2) {
                r = p1  - 1;
            } else if (l2 > r1) {
                l = p1 + 1;
            } else {
                if (len % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }
        }
        return -1;
    }
}

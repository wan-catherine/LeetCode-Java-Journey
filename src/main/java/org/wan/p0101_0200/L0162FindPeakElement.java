package org.wan.p0101_0200;

import java.util.Arrays;

public class L0162FindPeakElement {
    public int findPeakElement(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = Integer.MIN_VALUE;
        arr[arr.length - 1] = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        int len = arr.length;
        int left = 1;
        int right = len - 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] < arr[mid - 1]) {
                right = mid;
            }  else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    static void main() {
        int[] nums = new int[]{1, 2, 3, 1};
        L0162FindPeakElement p = new L0162FindPeakElement();
        System.out.println(p.findPeakElement(nums));
    }
}

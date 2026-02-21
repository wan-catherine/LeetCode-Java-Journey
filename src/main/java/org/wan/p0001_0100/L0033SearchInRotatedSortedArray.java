package org.wan.p0001_0100;

public class L0033SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len =  nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // this one doesn't work, because mid = left + (right - left) / 2 might be same as left .
//            if ((target >= nums[left]) == (nums[mid] >= nums[left])) {
//                if (target > nums[mid]) {
//                    left = mid + 1;
//                } else  {
//                    right = mid - 1;
//                }
//            } else if (target > nums[left]) {
//                right = mid - 1;
//            } else  {
//                left = mid + 1;
//            }
            if ((target > nums[right]) == (nums[mid] > nums[right])) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else  {
                    right = mid - 1;
                }
            } else if (target > nums[right]) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int search_(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

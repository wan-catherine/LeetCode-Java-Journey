package org.wan.p0001_0100;

public class L0081SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int len =  nums.length;
        int end = len - 1;
        while (end > 0 && nums[end] == nums[0]) {
            end -= 1;
        }
        int left = 0;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[right]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if  (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else  {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    static void main() {
        L0081SearchInRotatedSortedArrayII sol = new L0081SearchInRotatedSortedArrayII();
        int[] nums = new int[]{2,2,2,3,2,2,2};
        System.out.println(sol.search(nums, 3));
    }
}

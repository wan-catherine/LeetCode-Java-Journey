package org.wan.p0001_0100;

public class L0027RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int i = 0, j = len - 1;
        int res = 0;
        while (i <= j) {
            if (nums[i] != val) {
                i += 1;
                res += 1;
            } else {
                while (j > i && nums[j] == val) {
                    j -= 1;
                }
                if (j == i) {
                    return res;
                }
                nums[i] = nums[j];
                res += 1;
                i += 1;
                j -= 1;
            }
        }
        return res;
    }

    static void main() {
        L0027RemoveElement l = new L0027RemoveElement();
        int res = l.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
//        int res = l.removeElement(new int[]{1, 1}, 1);
        System.out.printf("%d\n", res);
    }
}


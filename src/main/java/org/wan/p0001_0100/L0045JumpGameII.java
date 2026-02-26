package org.wan.p0001_0100;

import java.util.ArrayList;

public class L0045JumpGameII {
    /*
    BFS
    need to be careful about when to update res
     */
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int res = 0;
        int[] visited = new int[len];
        visited[0] = 1;
        while (!list.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int idx : list) {
                if (nums[idx] + idx >= len - 1) {
                    return res + 1;
                }
                for (int i = 1; i <= nums[idx]; i++) {
                    int index = idx + i;
                    if (visited[index] == 0) {
                        visited[index] = 1;
                        temp.add(index);
                    }
                }

            }
            res += 1;
            list = temp;
        }
        return res;
    }
}

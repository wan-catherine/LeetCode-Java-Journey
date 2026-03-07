package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.List;

public class L0078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int start) {
        if (start == nums.length) {
            return;
        }
        int prev = nums[start];
        for (int i = start; i < nums.length; i++) {
            if (i > start  && nums[i] == prev) {
                continue;
            }
            prev = nums[i];
            cur.add(nums[i]);
            res.add(new ArrayList<>(cur));
            dfs(nums, res, cur, i+ 1);
            cur.removeLast();
        }
    }

    static void main() {
        L0078Subsets s = new L0078Subsets();
        List<List<Integer>> res = s.subsets(new int[]{1, 2, 3});
        System.out.println(res);
    }
}

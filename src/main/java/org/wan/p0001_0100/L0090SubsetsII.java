package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0090SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int idx, ArrayList<Integer> cur, ArrayList<List<Integer>> res) {
        res.add(new ArrayList<>(cur));
        int prev = -1;
        for (int i = idx; i < nums.length; i++) {
            if (prev > -1 && nums[i] == nums[prev]) continue;
            prev = i;
            cur.add(nums[i]);
            dfs(nums, i + 1, cur, res);
            cur.removeLast();
        }
    }

    static void main() {
        L0090SubsetsII s = new L0090SubsetsII();
        System.out.println(s.subsetsWithDup(new int[]{1, 2, 2}));
    }
}

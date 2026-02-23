package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0040CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, 0, new ArrayList<Integer>(), target, candidates, res);
        return res;
    }

    private void dfs(int idx, int cur, ArrayList<Integer> curLi, int target, int[] candidates,  List<List<Integer>> res) {
        if (cur == target) {
            res.add(new ArrayList<>(curLi));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            // remove duplicated in same level
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur += candidates[i];
            if (cur > target) {
                break;
            }
            curLi.add(candidates[i]);
            dfs(i + 1, cur, curLi, target, candidates, res);
            curLi.removeLast();
            cur -= candidates[i];
        }
    }
}

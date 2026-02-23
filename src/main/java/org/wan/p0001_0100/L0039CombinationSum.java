package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, 0, target, candidates, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int i, int cur, int target, int[] candidates, List<Integer> curLi, List<List<Integer>> result) {
        if (cur == target) {
            result.add(new ArrayList<>(curLi));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            cur += candidates[j];
            if (cur > target) {
                break;
            }
            curLi.add(candidates[j]);
            dfs(j, cur, target, candidates, curLi, result);
            cur -= candidates[j];
            curLi.removeLast();
        }
    }
}

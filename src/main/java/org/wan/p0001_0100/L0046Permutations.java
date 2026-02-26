package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.List;

public class L0046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == visited.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, res, list, visited);
            list.removeLast();
            visited[i] = false;
        }
    }

    static void main() {
        L0046Permutations l0046Permutations = new L0046Permutations();
        l0046Permutations.permute(new int[] {1,2,3});
    }
}

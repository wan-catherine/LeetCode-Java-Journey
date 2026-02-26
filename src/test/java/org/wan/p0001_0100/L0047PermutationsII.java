package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0047PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        int prex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (prex >= 0 && nums[i] == nums[prex]) {
                continue;
            }
            visited[i] = true;
            prex = i;
            list.add(nums[i]);
            dfs(nums, res, list, visited);
            list.removeLast();
            visited[i] = false;
        }
    }

    static void main() {
        L0047PermutationsII l0047PermutationsII = new L0047PermutationsII();
        l0047PermutationsII.permuteUnique(new int[] {1,1,2});
    }
}

package org.wan.p0101_0200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L0140WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        dfs(s, wordDict, res, new ArrayList<>(), map, 0);
        return res;
    }

    private boolean dfs(String s, List<String> wordDict, List<String> res, List<String> cur, HashMap<Integer, Boolean> map, int start) {
        if (start == s.length()) {
            res.add(String.join(" ", cur));
            return true;
        }
        if (map.containsKey(start) && map.get(start) == false) {
            return false;
        }
        boolean flag = false;
        for (String word : wordDict) {
            if (s.startsWith(word, start)) {
                cur.add(word);
                flag = flag | dfs(s, wordDict, res, cur, map, start + word.length());
                cur.removeLast();
            }
        }
        map.put(start, flag);
        return flag;
    }
}

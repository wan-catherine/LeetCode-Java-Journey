package org.wan.p0101_0200;

import java.util.HashMap;
import java.util.List;

public class L0139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s,0,wordDict, new HashMap<Integer, Boolean>());
    }
    private boolean dfs(String s, int start, List<String> wordDict, HashMap<Integer, Boolean> integerBooleanHashMap) {
        if (start == s.length()) {
            return true;
        }
        if (integerBooleanHashMap.containsKey(start)) {
            return integerBooleanHashMap.get(start);
        }
        for (String word : wordDict) {
            if (start + word.length() > s.length()) {
                continue;
            }
            if (s.startsWith(word, start)) {
                if (dfs(s, start + word.length(), wordDict, integerBooleanHashMap)) {
                    return true;
                }
            }
        }
        integerBooleanHashMap.put(start, Boolean.FALSE);
        return false;
    }
}

package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L0049GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

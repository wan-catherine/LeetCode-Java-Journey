package org.wan.p0001_0100;

import java.util.Arrays;
import java.util.Comparator;

public class L0014LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        int len = strs[0].length();
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (ch != str.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}

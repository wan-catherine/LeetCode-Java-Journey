package org.wan.p0001_0100;

import java.util.ArrayList;
import java.util.List;

public class L0068TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < len) {
            int j = i;
            int count = 0;
            List<String> temp = new ArrayList<>();
            while (j < len && count  + temp.size() - 1 + words[j].length() < maxWidth) {
                count += words[j].length();
                temp.add(words[j]);
                j += 1;
            }
            int tempLen = temp.size();
            int white = maxWidth - count;
            if (tempLen == 1 || j == len) {
                String s = String.join(" ", temp);
                if (s.length() < maxWidth) {
                    s += " ".repeat(maxWidth - s.length());
                }
                list.add(s);
            } else {
                List<String> temp2 = new ArrayList<>();
                int each = white / (tempLen - 1);
                int left = white - each * (tempLen - 1);
                for (int k = 0; k < tempLen; k++) {
                    String str = temp.get(k);
                    temp2.add(str);
                    int repeat = each;
                    if (left > 0) {
                        repeat += 1;
                        left -= 1;
                    }
                    if (k < tempLen - 1) {
                        temp2.add(" ".repeat(repeat));
                    }
                }
                list.add(String.join("", temp2));
            }
            i = j;
        }
        return list;
    }
}

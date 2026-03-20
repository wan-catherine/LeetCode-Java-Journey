package org.wan.p0101_0200;

import java.util.Collections;
import java.util.List;

public class L0120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len =  triangle.size();
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int value = triangle.get(i).get(j);
                int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    left = value + triangle.get(i-1).get(j - 1);
                }
                if (j < triangle.get(i-1).size()) {
                    up = value + triangle.get(i-1).get(j);
                }
                triangle.get(i).set(j, Math.min(left, up));
            }
            System.out.println(triangle.get(i));
        }
        return Collections.min(triangle.get(len - 1));
    }
}

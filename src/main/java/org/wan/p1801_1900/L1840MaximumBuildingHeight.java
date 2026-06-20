package org.wan.p1801_1900;

import java.util.ArrayList;
import java.util.List;

public class L1840MaximumBuildingHeight {
    public int maxBuilding(int n, int[][] restrictions) {
        List<long[]> list = new ArrayList<>();
        list.add(new long[]{1,0});

        for(int[] r :  restrictions) {
            list.add(new long[]{r[0],r[1]});
        }

        list.sort((a, b) -> Long.compare(a[0], b[0]));
        if (list.getLast()[0] < n) {
            list.add(new long[]{n, n-1});
        }

        int length =  list.size();

        for (int i = 1; i < length; i++) {
            long prevId = list.get(i-1)[0];
            long currId = list.get(i)[0];
            long preHeight = list.get(i-1)[1];
            long currHeight = list.get(i)[1];

            long distance = currId - prevId;
            list.get(i)[1] = Math.min(currHeight, preHeight + distance);
        }

        for (int i = length-2; i >= 0; i--) {
            long nextId = list.get(i+1)[0];
            long currId = list.get(i)[0];
            long nextHeight = list.get(i+1)[1];
            long currHeight = list.get(i)[1];
            long distance = nextId - currId;
            list.get(i)[1] = Math.min(currHeight, nextHeight + distance);
        }

        long res = 0;
        for (int i = 1; i < length; i++) {
            long prevId = list.get(i-1)[0];
            long currId = list.get(i)[0];
            long preHeight = list.get(i-1)[1];
            long currHeight = list.get(i)[1];
            long distance = currId - prevId;
            long peak = (preHeight + currHeight + distance) / 2;
            res = Math.max(res, peak);
        }
        return (int) res;
    }
}

package org.wan.p3601_3700;

public class L3614ProcessStringWithSpecialOperationsII {
    public char processStr(String s, long k) {
        long len = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                len += 1;
            } else if (c == '*') {
                len = Math.max(0, len - 1);
            } else if (c == '#') {
                len *= 2;
            } else if (c == '%') {
                // reverse doesn't change len, do nothing here
            }
        }

        if (k >= len) {
            return '.';
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (k == len - 1) {
                    return c;
                }
                len -= 1;
            } else if (c == '*') {
                len += 1;
            } else if (c == '#') {
                // old + old
                len /= 2;
                if (k >= len) {
                    k -= len;
                }
            } else if (c == '%') {
                k = len - 1 - k;
            }
        }

        return '.';
    }
}

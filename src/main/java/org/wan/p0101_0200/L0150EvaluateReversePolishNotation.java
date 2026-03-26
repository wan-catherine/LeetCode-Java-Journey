package org.wan.p0101_0200;

import java.util.ArrayList;
import java.util.Arrays;

public class L0150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        ArrayList<String> stack = new ArrayList<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int second = Integer.parseInt(stack.removeLast());
                int first = Integer.parseInt(stack.removeLast());
                if (token.equals("+")) {
                    stack.add(String.valueOf(first + second));
                } else if (token.equals("-")) {
                    stack.add(String.valueOf(first - second));
                } else if (token.equals("*")) {
                    stack.add(String.valueOf(first * second));
                } else {
                    stack.add(String.valueOf(first / second));
                }
            } else {
                stack.add(token);
            }
        }
        return Integer.parseInt(stack.getLast());
    }

    static void main() {
        String[] tokens = {"4","13","5","/","+"};
        L0150EvaluateReversePolishNotation eval = new L0150EvaluateReversePolishNotation();
        System.out.println(eval.evalRPN(tokens));
    }
}

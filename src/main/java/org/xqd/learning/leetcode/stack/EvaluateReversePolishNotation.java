package org.xqd.learning.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
//        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
//        evalRPN(tokens);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                stack.push(calResult(stack.pop(), stack.pop(), token));
            }
        }

        return stack.pop();
    }

    private Integer calResult(Integer number1, Integer number2, String token) {
        int result = 0;
        switch (token) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number2 - number1;
                break;
            case "*":
                result = number2 * number1;
                break;
            case "/":
                result = number2 / number1;
                break;
        }

        return result;
    }
}

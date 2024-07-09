package org.xqd.learning.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class ValidParentheses {
    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isLeft = map.get(c) == null;

            if (isLeft) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}

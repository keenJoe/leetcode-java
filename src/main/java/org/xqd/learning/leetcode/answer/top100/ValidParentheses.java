package org.xqd.learning.leetcode.answer.top100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) != null) {
                if (stack.size() > 0) {
                    char pop = stack.pop();
                    if (pop != map.get(c)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }

        if (stack.size() > 0) return false;


        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("[{]}"));
        System.out.println(isValid("}{"));
        System.out.println(isValid("{"));
        System.out.println(isValid("}"));
        System.out.println(isValid("{{}}"));
        System.out.println(isValid("{}[]{}()"));
    }
}

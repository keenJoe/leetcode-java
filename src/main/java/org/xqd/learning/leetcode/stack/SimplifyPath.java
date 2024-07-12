package org.xqd.learning.leetcode.stack;

import java.util.ArrayDeque;

/**
 * 71. Simplify Path
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) return null;

        String[] split = path.trim().split("/");
        ArrayDeque<String> deque = new ArrayDeque<>();

        for (String s : split) {
            if (s != null && !s.isEmpty()) {
                if (s.equals(".")) {
                    continue;
                } else if (s.equals("..")) {
                    //从队尾取出一个元素
                    deque.pollLast();
                } else {
                    deque.addLast("/" + s);
                }
            }
        }

        if (deque.isEmpty()) return "/";

        StringBuilder builder = new StringBuilder();
        for (String s : deque) {
            builder.append(s);
        }

        return builder.toString();
    }
}

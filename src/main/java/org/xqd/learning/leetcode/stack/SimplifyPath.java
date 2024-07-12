package org.xqd.learning.leetcode.stack;

import java.util.ArrayDeque;

/**
 * 71. Simplify Path
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) return null;

        String[] split = path.trim().split("/");
        if (split.length == 0) return "/";

        ArrayDeque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s != null && !s.isEmpty()) {
                if (s.equals(".")) {
                    String last = deque.peekLast();
                    if (last == null) {
                        deque.addLast("/");
                    }
                } else if (s.equals("..")) {
                    //从队尾取出一个元素
                    String last = deque.peekLast();
                    if (last == null) {
                        deque.addLast("/");
                    } else if ("/".equals(last)) {
                        continue;
                    } else {
                        deque.pollLast();
                        if (deque.peekLast() == null) {
                            deque.addLast("/");
                        }
                    }
                } else {
                    String last = deque.peekLast();
                    if ("/".equals(last)) {
                        deque.addLast(s);
                    } else {
                        deque.addLast("/" + s);
                    }
                }
            }
        }

        System.out.println(deque);
        StringBuilder builder = new StringBuilder();
        for (String s : deque) {
            builder.append(s);
        }

        return builder.toString();
    }
}

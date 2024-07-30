package org.xqd.learning.leetcode.stack;

import sun.nio.ch.sctp.SendFailed;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 */
public class MyQueue {
    private Stack<Integer> stack = null;
    private Stack<Integer> second = null;

    public MyQueue() {
        stack = new Stack<>();
        second = new Stack<>();
    }

    //将元素 x 推到队列的末尾
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
        } else {
            while (!stack.isEmpty()) {
                second.push(stack.pop());
            }

            stack.push(x);

            while (!second.isEmpty()) {
                stack.push(second.pop());
            }
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

package org.xqd.learning.leetcode.stack;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * 225. Implement Stack using Queues
 */
public class MyStack {
    //双端队列
    private LinkedBlockingDeque<Integer> deque;

    public MyStack() {
        deque = new LinkedBlockingDeque<>();
    }

    //将元素 x 压入栈顶
    public void push(int x) {
        deque.addFirst(x);
    }

    //移除并返回栈顶元素
    public int pop() {
        return deque.pop();
    }

    //返回栈顶元素
    public int top() {
        return deque.getFirst();
    }

    //如果栈是空的，返回 true ；否则，返回 false
    public boolean empty() {
        return deque.isEmpty();
    }
}

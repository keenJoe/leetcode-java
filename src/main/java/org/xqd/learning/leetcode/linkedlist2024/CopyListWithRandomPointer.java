package org.xqd.learning.leetcode.linkedlist2024;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        Node dummy = new Node(0);
        Node q = dummy;
        while (p != null) {
            q.next = new Node(p.val);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        p = head;
        q = dummy;
        while (p != null) {
            /*
              这么简单一直没想通
              map 中存放的是原节点和新节点的一一对应关系
              p.random 得到 random 指针对应的原节点，通过这个原节点可以得到新节点
              比如 p 是 13，random 指向了 7，那么p.random 就是指向了 节点7，那么 map.get(p.random) 得到的就是原节点7对应的新节点7
             */
            q.next.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }
}

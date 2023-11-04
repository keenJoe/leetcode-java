package org.xqd.learning.leetcode.linkedlist;

import org.xqd.learning.leetcode.pojo.ListNode;

/**
 * 725. Split Linked List in Parts
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = length(head);
        int i = length / k;
        int j = length % k;

        ListNode[] listNodes = new ListNode[k];
        if (i == 0) {
            int t = 0;
            while (head != null) {
                listNodes[t] = head;

                ListNode next = head.next;
                head.next = null;
                head = next;
                t++;
            }
        } else {
            int t = 0;
            for (int i1 = 0; i1 < length && head != null; i1++) {
                listNodes[t] = head;
                t++;

                int step = i;
                if (j != 0) {
                    step += 1;
                    j--;
                }

                for (int j1 = 1; j1 < step; j1++) {
                    head = head.next;
                }

                ListNode next = head.next;
                head.next = null;
                head = next;

            }
        }

        return listNodes;
    }

    private int length(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }

        return l;
    }
}

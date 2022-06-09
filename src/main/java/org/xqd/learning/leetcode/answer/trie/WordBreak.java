package org.xqd.learning.leetcode.answer.trie;

import java.util.List;

/**
 * @author XuQidong
 * @date 2022/5/18 12:43
 *
 * LeetCode 139. Word Break
 */
public class WordBreak {
    class Node {
        private int pass;
        private int end;
        private Trie.Node[] nodes;

        public Node() {
            pass = 0;
            end = 0;
            nodes = new Trie.Node[26];
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    public static void main(String[] args) {

    }
}

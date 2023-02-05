package org.xqd.learning.leetcode.answer.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 211. Design Add and Search Words Data Structure
 */

public class WordDictionary {
    public class Node {
        public int pass;
        public int end;
        public Map<Character, Node> map;

        public Node() {
            pass = 0;
            end = 0;
            map = new HashMap<>();
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        if (word == null) {
            return;
        }

        char[] chars = word.toCharArray();
        Node node = root;
        node.pass++;

        for (char aChar : chars) {
            if (node.map.get(aChar) == null) {
                Node node1 = node.map.get(aChar);
                node1 = new Node();
                node.map.put(aChar, node1);
            }

            node = node.map.get(aChar);
            node.pass++;
        }

        node.end++;
    }

    public boolean search(String word) {
        if (word == null) return false;

        char[] chars = word.toCharArray();
        Node node = root;

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '.') {
                for (Map.Entry<Character, Node> entry : node.map.entrySet()) {
                    boolean search = deepSearch(entry.getValue(), word.substring(i + 1));
                    if (search) return true;
                }

                //important
                return false;
            } else {
                if (node.map.get(aChar) == null) {
                    return false;
                }

                node = node.map.get(aChar);
            }
        }

        if (node.end == 0) {
            return false;
        }

        return true;
    }

    /**
     * return TRUE if exists, or FALSE otherwise
     * if FALSE, keep on searching
     *
     * @param node
     * @param word
     */
    public boolean deepSearch(Node node, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '.') {
                for (Map.Entry<Character, Node> entry : node.map.entrySet()) {
                    boolean search = deepSearch(entry.getValue(), word.substring(i + 1));
                    if (search) {
                        return true;
                    }
                }

                //important
                return false;
            } else {
                if (node.map.get(aChar) == null) {
                    return false;
                }

                node = node.map.get(aChar);
            }
        }

        if (node.end == 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        wordDictionary.addWord("bat");

        System.out.println(wordDictionary.search("a.d.")); // return False

    }
}

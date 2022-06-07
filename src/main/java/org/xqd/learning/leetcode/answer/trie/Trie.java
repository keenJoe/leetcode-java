package org.xqd.learning.leetcode.answer.trie;

public class Trie {
    class Node {
        private int pass;
        private int end;
        private Node[] nodes;

        public Node() {
            pass = 0;
            end = 0;
            nodes = new Node[26];
        }
    }

    //define a trie
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }

        char[] chars = word.toCharArray();
        Node node = root;
        node.pass++;

        for (char aChar : chars) {
            int index = aChar - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new Node();
            }

            node = node.nodes[index];
            node.pass++;
        }

        node.end++;
    }

    public boolean search(String word) {
        if (word == null) return false;

        char[] chars = word.toCharArray();

        Node node = root;

        for (char aChar : chars) {
            int path = aChar - 'a';
            if (node.nodes[path] == null) {
                return false;
            }

            node = node.nodes[path];
        }

        if (node.end == 0) {
            return false;
        }

        return true;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) return false;

        char[] chars = prefix.toCharArray();

        Node node = root;

        for (char aChar : chars) {
            int path = aChar - 'a';
            if (node.nodes[path] == null) {
                return false;
            }

            node = node.nodes[path];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("application");
        trie.insert("appwatch");
        trie.insert("apply");
        trie.insert("appreciate");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("appl"));
    }
}

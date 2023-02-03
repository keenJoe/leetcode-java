package org.xqd.learning.leetcode.answer.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 200. Number of Islands
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int i = numIslands(grid);
        //int j = numIslands1(grid);

        System.out.println("结果" + i);
        //System.out.println("结果" + j);
    }

    /**
     * using union find
     */
    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Node node = new Node(rows, columns);
        System.out.println("当前的 parent: " + node.parent);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    node.union(i, j, grid);
                }
            }
        }

        System.out.println(node.parent);

        return rows * columns - node.getNumber();
    }

    static class Node {
        //初始化时，每个 node 的 parent 都是自己，所以存放的值就是(index,index)
        Map<Integer, Integer> parent = new HashMap<>();

        //初始化时，每个 node 的大小都是 1
        Map<Integer, Integer> size = new HashMap<>();

        Set<Integer> sets = new HashSet<>();

        public Node(int i, int j) {
            for (int i1 = 0; i1 < i; i1++) {
                for (int j1 = 0; j1 < j; j1++) {
                    int index = i1 * i + j1;
                    parent.put(index, index);
                    size.put(index, 1);
                }
            }
        }

        public void union(int i, int j, char[][] grid) {
            int n = grid.length;
            int ip = findParent(i, j, n);
            //和当前节点的上面节点合并
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                int jp = findParent(i - 1, j, n);
                if (ip != jp) {
                    if (size.get(jp) >= size.get(ip)) {
                        size.put(jp, size.get(ip) + size.get(jp));
                        parent.put(ip, jp);
                        sets.add(ip);
                    } else {
                        size.put(ip, size.get(ip) + size.get(jp));
                        parent.put(jp, ip);
                        sets.add(jp);
                    }
                }
            }

            //和当前节点的左侧节点合并
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                int jp = findParent(i, j - 1, n);
                if (ip != jp) {
                    if (size.get(jp) >= size.get(ip)) {
                        size.put(jp, size.get(ip) + size.get(jp));
                        parent.put(ip, jp);
                        sets.add(ip);
                    } else {
                        size.put(ip, size.get(ip) + size.get(jp));
                        parent.put(jp, ip);
                        sets.add(jp);
                    }
                }
            }
        }

        public int findParent(int i, int j, int n) {
            int p = i * n + j;
            System.out.println("p: " + p + ",i: " + i + ",j: " + j);

            while (p != parent.get(p)) {
                System.out.println("当前的P:" + p);
                //目前[i][j]的 parent，//但是需要向上寻找最上的 parent
                p = parent.get(p);
            }

            return p;
        }

        public int getNumber() {
            return sets.size();
        }
    }


    /**
     * infecting
     */
    public static int numIslands1(char[][] grid) {
        int islandNumber = 0;
        int row = grid.length;
        for (int i = 0; i < row; i++) {

            int column = grid[i].length;
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    islandNumber++;
                    infect(i, j, row, column, grid);
                }
            }
        }

        return islandNumber;
    }

    private static void infect(int i, int j, int row, int column, char[][] grid) {
        if (i >= 0 && j >= 0 && i < row && j < column) {
            if (grid[i][j] == '1') {
                grid[i][j] = '2';
                infect(i - 1, j, row, column, grid);
                infect(i + 1, j, row, column, grid);
                infect(i, j - 1, row, column, grid);
                infect(i, j + 1, row, column, grid);
            }
        }
    }
}

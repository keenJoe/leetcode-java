package org.xqd.learning.leetcode.answer.unionfind;

import javax.sound.midi.Soundbank;

/**
 * 547. Number of Provinces
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = new int[3][3];
        isConnected[0][0] = 1;
        isConnected[1][1] = 1;
        isConnected[2][2] = 1;
        isConnected[0][1] = 1;
        isConnected[1][0] = 1;
        int circleNum = findCircleNum(isConnected);
        System.out.println(circleNum);
    }

    public static int findCircleNum(int[][] isConnected) {
        UnionFind unionFind = new UnionFind(isConnected.length);
        System.out.println("数组长度" + isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.sets;
    }

    static class UnionFind {
        int[] parent;

        int[] size;

        int sets;

        //辅助数组，存放了从开始查找的节点到 parent 节点中间的 path 上所有的路过的节点
        int[] help;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            help = new int[n];
            sets = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int index) {
            int helpi = 0;

            //find final parent of index
            while(index != parent[index]){
                help[helpi++] = index;
                index = parent[index];
            }

            //compress path, set index as parent node to all nodes in this path
//            for (int i = helpi; i >= 0; i--) {
//                help[i] = index;
//            }

            /**
             * 这个和下面的答案完全不是一个意思
             */
//            for (int i = helpi--; i >= 0; i--) {
//                parent[help[helpi]] = index;
//            }

            for (helpi--; helpi >= 0; helpi--) {
                parent[help[helpi]] = index;
            }

            return index;
        }

        public void union(int i, int j) {
//            int i1 = find(i);
//            int i2 = find(j);
//            if (i1 != i2) {
//                if (size[i] >= size[j]) {
//                    parent[j] = i1;
//                    size[i]++;
//                } else {
//                    parent[i] = i2;
//                    size[j]++;
//                }
//
//                sets--;
//            }

            /**
             * 其实最后就纯属于p1 和 p2 两个 parent 节点比较，和 i j 都无关了
             * 比如比较集合大小，也是比较两个 parent 的子集
             */
            int p1 = find(i);
            int p2 = find(j);
            if (p1 != p2) {
                if (size[p1] >= size[p2]) {
                    parent[p2] = p1;
                    size[p1] += size[p2];
                } else {
                    parent[p1] = p2;
                    size[p2] += size[p1];
                }

                sets--;
            }
        }
    }
}

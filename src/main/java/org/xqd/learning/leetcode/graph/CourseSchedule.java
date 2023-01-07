package org.xqd.learning.leetcode.graph;

import java.util.*;

/**
 * @author XuQidong
 * @date 2022/12/11 16:00
 * 207. Course Schedule
 */
public class CourseSchedule {

    public static void main(String[] args) {
//        int[][] courses = {{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
//        boolean b = canFinish(4, courses);
//        System.out.println(b);
    }

    /**
     * 使用图的方式
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        return false;
    }

    public boolean isCanFinish(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 只有剩余入度为0的点，才进入这个队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }

        return result.size() <= 0;
    }

    static class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }

    static class Node {
        public int value;
        public int in;
        public int out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    public static int[] canFinish1(int numCourses, int[][] prerequisites) {
        if (numCourses > 0 && prerequisites.length == 0) return true;

        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == prerequisite[1]) return false;
        }

        //统计每个 prerequisite[0]的入度值
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (map.get(prerequisite[0]) == null || map.get(prerequisite[0]) == 0) {
                map.put(prerequisite[0], 1);
            } else {
                Integer size = map.get(prerequisite[0]);
                map.put(prerequisite[0], size + 1);
            }
        }

        //不需要依赖其他课程就可以完成的课程，入度为0
        Queue<Integer> zeroQueue = new PriorityQueue<>();
        for (int[] prerequisite : prerequisites) {
            // 这里一定不要重复添加数据
            if (map.get(prerequisite[1]) == null && !zeroQueue.contains(prerequisite[1])) {
                zeroQueue.add(prerequisite[1]);
            }
        }

//        Set<Integer> result = new HashSet<>();
        Queue<Integer> result = new PriorityQueue<>();
        while (!zeroQueue.isEmpty()) {
            Integer courseId = zeroQueue.poll();
            result.add(courseId);

            if (map.size() > 0) {
                for (int[] prerequisite : prerequisites) {
                    //解锁一个课程
                    if (prerequisite[1] == courseId) {
                        if (map.get(prerequisite[0]) != null && map.get(prerequisite[0]) == 1) {
                            zeroQueue.add(prerequisite[0]);
                            map.remove(prerequisite[0]);
                        } else {
                            Integer size = map.get(prerequisite[0]);
                            map.put(prerequisite[0], size - 1);
                        }
                    }
                }
            }
        }

        int[] array = new int[numCourses];
        if (map.size() <= 0) {
            for (int i = 0; i < result.size(); i++) {
                array[i] = result.poll();
            }
        }

        return array;
    }
}

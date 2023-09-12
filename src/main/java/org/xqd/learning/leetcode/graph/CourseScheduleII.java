package org.xqd.learning.leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 210. Course Schedule II
 */
public class CourseScheduleII {

    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1, 0}, {0, 1}};
        int[][] arr = new int[][]{{1, 0}, {1, 2}, {0, 1}};
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] order = courseScheduleII.findOrder(2, arr);
        System.out.println("======================");
        for (int i : order) {
            System.out.println(i);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if ((prerequisites == null || prerequisites.length == 0) && numCourses > 0) {
            int[] a = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                a[i] = i;
            }

            return a;
        }

        Graph graph = new Graph();
        //1、构造graph prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        for (int[] prerequisite : prerequisites) {
            int out = prerequisite[0];
            Node outNode = null;
            if (graph.nodes.get(out) != null) {
                outNode = graph.nodes.get(out);
            } else {
                outNode = new Node(out);
            }

            int in = prerequisite[1];
            Node inNode = null;
            if (graph.nodes.get(in) != null) {
                inNode = graph.nodes.get(in);
            } else {
                inNode = new Node(in);
            }

            //记录inNode的出度
            if (!inNode.outNodes.contains(outNode)) {
                inNode.outNodes.add(outNode);
                inNode.out += 1;
                graph.nodes.put(in, inNode);
                System.out.println("in: " + in + "-->" + inNode.out);
                System.out.println("in: " + in + "-->" + inNode.in);
            }

            //记录outNode的入度
            if (!outNode.inNodes.contains(inNode)) {
                outNode.inNodes.add(inNode);
                outNode.in += 1;
                graph.nodes.put(out, outNode);
                System.out.println("out: " + out + "-->" + outNode.out);
                System.out.println("out: " + out + "-->" + outNode.in);
            }

            System.out.println("==============");
        }

        for (int i = 0; i < numCourses; i++) {
            if (graph.nodes.get(i) == null) {
                Node node = new Node(i);
                node.in = 0;
                node.out = 0;
                graph.nodes.put(i, node);
            }
        }

        System.out.println("=======");

        List<Node> collect = graph.nodes.values().stream().sorted(Comparator.comparing(Node::getIn)).collect(Collectors.toList());

        int[] array = {};
        for (int i = 0; i < collect.size(); i++) {
            Node node = collect.get(i);
            System.out.println("当前node的值: " + node.value);
            System.out.println("当前node的in值：" + node.in);
            System.out.println("当前node的out值：" + node.out);

            if (i == collect.size() - 1) {
                if (node.in > 0) {
                    int[] temp = {};
                    return temp;
                }
            }

            if (node.in == 0) {
                if (array.length == 0) array = new int[numCourses];

                graph.nodes.remove(node.value);
                array[i] = node.value;

                for (Node next : node.outNodes) {
                    Node temp = graph.nodes.get(next.value);
                    if (temp != null) {
                        temp.in -= 1;
                        graph.nodes.put(temp.value, temp);
                    }
                }
            }

            System.out.println("==================");
        }

        return array;
    }

    public class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }

    public class Node {
        public Integer value;
        public Integer in;
        public Integer out;
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public ArrayList<Node> inNodes;
        public ArrayList<Node> outNodes;

        public Node(int value) {
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();

            inNodes = new ArrayList<>();
            outNodes = new ArrayList<>();
        }

        public Integer getIn() {
            return in;
        }

        public Integer getOut() {
            return out;
        }
    }

    public class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }
}

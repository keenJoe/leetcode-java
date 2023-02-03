package org.xqd.learning.leetcode.answer.graph;

import java.util.*;

/**
 * 207. Course Schedule
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, prerequisites));
    }

    /**
     * 老老实实地用 topological sort
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * 将解锁的课程放到队列中，遍历队列，知道队列中没有任何课程
         * 注意[1,0] 和 [0,1] 的情况以及[0,0]的情况，这两种情况无法完成course schedule
         */
        Set<Integer> set0 = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            set0.add(prerequisite[0]);
        }

        //不需要依赖其他课程就可以完成的课程，入度为 0
        Queue<Integer> zeroQueue = new PriorityQueue<>();
        for (int[] prerequisite : prerequisites) {
            if (!set0.contains(prerequisite[1])) {
                zeroQueue.add(prerequisite[1]);
            }
        }

        Set<Integer> result = new HashSet<>();
        while (!zeroQueue.isEmpty()) {
            Integer courseId = zeroQueue.poll();
            result.add(courseId);

            for (int[] prerequisite : prerequisites) {
                //解锁一个课程
                if (prerequisite[1] == courseId) {
                    zeroQueue.add(prerequisite[0]);
                }
            }
        }

        if (result.size() == numCourses) {
            return true;
        }

        return false;
    }

    class Course {
        int courseId;
        int in;
        List<Course> neighbors;

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public List<Course> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(List<Course> neighbors) {
            this.neighbors = neighbors;
        }
    }

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == prerequisite[1]) return false;
        }


        Set<Integer> course = new HashSet<>();

        Set<Integer> set0 = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            set0.add(prerequisite[0]);
        }

        Set<Integer> set1 = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            set1.add(prerequisite[1]);
        }

        course.addAll(set0);
        course.retainAll(set1);
        Set<Integer> retainSet = course;
        System.out.println("长度: " + retainSet.size());
        boolean b1 = retainSet.size() < numCourses || retainSet.isEmpty();
        System.out.println("b1: " + b1);

        course.clear();
        course.addAll(set0);
        course.addAll(set1);
        Set<Integer> allSet = course;
        System.out.println("长度: " + allSet.size());

//        boolean b1 = retainSet.size() < numCourses || retainSet.isEmpty();
//        System.out.println("b1: " + b1);

        boolean b2 = allSet.size() == numCourses;
        System.out.println("b2: " + b2);

        return b1 && b2;
    }
}

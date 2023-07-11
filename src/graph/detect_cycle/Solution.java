package graph.detect_cycle;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Leetcode Question 210: Course schedule II
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them. If it is impossible to finish all courses,
 * return an empty array.
 */
public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] adjLst = Arrays.stream(new List[numCourses]).
                map(l -> new ArrayList<Integer>()).toArray(List[]::new);

        // get adjacent list representation of graph
        Arrays.stream(prerequisites).
                forEach(prerequisite -> adjLst[prerequisite[1]].add(prerequisite[0]));


        // result to return
        int[] order = new int[numCourses];

        // get indegree
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adjLst[i]) {
                indegree[neighbor]++;
            }
        }

        // BFS
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> toExplore = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                toExplore.add(i);
                order[count++] = i;
            }
        }


        while (!toExplore.isEmpty()) {
            int cur = toExplore.poll();
            for (int neighbor : adjLst[cur]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    toExplore.add(neighbor);
                    order[count++] = neighbor;
                }

            }
        }

        if (count != numCourses) return new int[0];

        return order;
    }

    @Test
    void test() {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = findOrder(4, prerequisites);
        System.out.println(Arrays.toString(order));
    }

    void test1() {
        int[][] prerequisites = {};
        int[] order = findOrder(2, prerequisites);
        System.out.println(Arrays.toString(order));
    }


}

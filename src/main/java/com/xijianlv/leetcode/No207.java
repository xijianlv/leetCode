package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xijianlv
 */
public class No207 {

    public List<List<Integer>> init(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            graph.get(cp[1]).add(cp[0]);
        }
        return graph;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = init(numCourses, prerequisites);
        int[] flags = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (Integer k : graph.get(i)) {
            if (!dfs(graph, flags, k)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}

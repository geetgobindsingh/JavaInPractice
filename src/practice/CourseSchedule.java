package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        /*
        There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

        Some courses may have prerequisites,
        for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

        Given the total number of courses and a list of prerequisite pairs,
        is it possible for you to finish all courses?
         */
        CourseSchedule cs = new CourseSchedule();
        System.out.println(cs.canFinish(0, new int[][]{{1, 0}}));
        System.out.println(cs.canFinish(1, new int[][]{}));
        System.out.println(cs.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(cs.canFinish(2, new int[][]{{0, 1}}));
        System.out.println(cs.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println();
        System.out.println(cs.canFinishBFS(0, new int[][]{{1, 0}}));
        System.out.println(cs.canFinishBFS(1, new int[][]{}));
        System.out.println(cs.canFinishBFS(2, new int[][]{{1, 0}}));
        System.out.println(cs.canFinishBFS(2, new int[][]{{0, 1}}));
        System.out.println(cs.canFinishBFS(2, new int[][]{{1, 0}, {0, 1}}));
    }

    private boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return false;
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j : graph[i]) {
                inDegrees[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }
        boolean[] visited = new boolean[numCourses];
        int count = 0;
        while (q.size() > 0) {
            int node = q.poll();
            count++;
            if (visited[node] == true) return false;
            visited[node] = true;
            for (int u : graph[node]) {
                inDegrees[u]--;
                if (inDegrees[u] == 0) {
                    q.offer(u);
                }
            }
        }

        return count == numCourses;
    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return false;
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                boolean flag = topoDFS(i, graph, visited);
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean topoDFS(int i, List<Integer>[] graph, boolean[] visited) {
        if (visited[i]) return false;
        visited[i] = true;
        for (int j : graph[i]) {
            boolean flag = topoDFS(j, graph, visited);
            if (!flag) {
                return false;
            }
        }
        visited[i] = false;
        return true;
    }


}

package leetcode.medium;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {

        CourseScheduleII obj = new CourseScheduleII();
//        obj.display(obj.findOrder(2, new int[][]{{1, 0}}));
//        obj.display(obj.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        obj.display(obj.findOrder(3, new int[][]{{2, 1}, {1, 0}}));
    }

    private void display(int[] order) {
        for (int i : order) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
        }
        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            g[start].add(end);
            inDegrees[end]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int i = 0;
        int count = 0;
        while (q.size() > 0) {
            int u = q.poll();
            order[i++] = u;
            for (int v : g[u]) {
                if (--inDegrees[v] == 0) {
                    q.offer(v);
                }
            }
            count++;
        }
        if (count == numCourses) {
            return order;
        }
        return new int[]{};
    }
}

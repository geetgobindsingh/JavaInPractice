package leetcode.medium;

import java.util.*;

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
        System.out.print("\n");
        System.out.println(cs.canFinishTopologicalSort(0, new int[][]{{1, 0}}));
        System.out.println(cs.canFinishTopologicalSort(1, new int[][]{}));
        System.out.println(cs.canFinishTopologicalSort(2, new int[][]{{1, 0}}));
        System.out.println(cs.canFinishTopologicalSort(2, new int[][]{{0, 1}}));
        System.out.println(cs.canFinishTopologicalSort(2, new int[][]{{1, 0}, {0, 1}}));
    }


    public boolean canFinishTopologicalSort(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return false;
        }
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[graph.length];
        for (int v = 0; v < graph.length; v++) {
            if (!topologicalSort(v, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean topologicalSort(int src, List<Integer>[] graph, boolean[] visited) {
        if (visited[src]) return false;
        visited[src] = true;
        for (Integer e : graph[src]) {
            if (!topologicalSort(e, graph, visited)) {
                return false;
            }
        }
        visited[src] = false;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) {
            return false;
        }

        int matrix[][] = new int[numCourses][numCourses];

        for (int index_i = 0; index_i < prerequisites.length; ++index_i) {
            matrix[prerequisites[index_i][1]][prerequisites[index_i][0]] = 1;
        }

        int[] inDegrees = new int[numCourses];
        for (int index_i = 0; index_i < numCourses; ++index_i) {
            for (int index_j = 0; index_j < numCourses; ++index_j) {
                if (matrix[index_i][index_j] == 1) {
                    inDegrees[index_j]++;
                }
            }
        }

        Queue<Integer> queue = new PriorityQueue<>();
        int counter = 0;
        for (int index = 0; index < numCourses; ++index) {
            if (inDegrees[index] == 0) {
                queue.add(index);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            counter++;
            for (int index = 0; index < numCourses; ++index) {
                if (matrix[vertex][index] == 1) {
                    inDegrees[index]--;
                    if (inDegrees[index] == 0) {
                        queue.add(index);
                    }
                }
            }
        }

        return counter == numCourses;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites, boolean a) {
        boolean[] visited = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int[] prerequisit : prerequisites) {
            int source = prerequisit[0];
            int target = prerequisit[1];
            if (map.containsKey(source)) {
                map.get(source).add(target);
            }else {
                List<Integer> dependencyList = new ArrayList<>();
                dependencyList.add(target);
                map.put(source,dependencyList);
            }
        }
        Arrays.fill(visited,false);
        Arrays.fill(checked,false);
        for (int i=0;i<numCourses;i++) {
            if (isCyclic(i, map, visited,checked)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCyclic(int courseNumber, Map<Integer, List<Integer>> map, boolean[] visited, boolean[] checked) {
        if(checked[courseNumber])
            return false;
        if(visited[courseNumber])
            return true;
        if(!map.containsKey(courseNumber))
            return false;
        visited[courseNumber] = true;
        boolean isCyclic = false;
        List<Integer> prerequisitCourseList = map.get(courseNumber);
        for (int i=0;i<prerequisitCourseList.size();i++) {
            isCyclic =  isCyclic(prerequisitCourseList.get(i), map,visited,checked);
            if(isCyclic) {
                break;
            }
        }
        visited[courseNumber] = false;
        checked[courseNumber] =true;
        return isCyclic;
    }
}

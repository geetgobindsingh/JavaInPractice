package practice;

public class CourseSchedule {
    public static void main(String[] args) {
        /*
        There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

        Some courses may have prerequisites,
        for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

        Given the total number of courses and a list of prerequisite pairs,
        is it possible for you to finish all courses?
         */
        leetcode.medium.CourseSchedule cs = new leetcode.medium.CourseSchedule();
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


}

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> coursesPrereq = new HashMap<>();
        Set<Integer> visit = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            coursesPrereq.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0];
            int value = prerequisite[1];

            coursesPrereq.get(key).add(value);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(coursesPrereq, visit, i)) return false;
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> coursesPrereq, Set<Integer> visit, int key) {
        if (visit.contains(key)) {
            return false;
        }

        if (coursesPrereq.get(key).isEmpty()) {
            return true;
        }

        visit.add(key);

        for (Integer prerequisite : coursesPrereq.get(key)) {
            if (!dfs(coursesPrereq, visit, prerequisite)) {
                return false;
            }
        }

        coursesPrereq.get(key).clear();
        visit.remove(key);

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();

        int numCourses = 5;
        int[][] prerequisites = new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};

        System.out.println(cs.canFinish(numCourses, prerequisites));
    }
}

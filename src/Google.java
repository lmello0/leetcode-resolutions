import java.util.*;

public class Google {
    private int[][] issues;            // Adjacency matrix
    private boolean[] visited;         // Tracks visited nodes
    private Map<Integer, Integer> indexMap; // Maps nodes to their position in the DFS path
    private List<List<Integer>> result; // Stores detected cycles

    public Google(int[][] issues) {
        this.issues = issues;
        this.visited = new boolean[issues.length];
        this.indexMap = new HashMap<>();
        this.result = new ArrayList<>();
    }

    // Finds and returns all cycles in the dependency graph
    public List<List<Integer>> findCycles() {
        for (int idx = 0; idx < issues.length; idx++) {
            if (!visited[idx]) {
                List<Integer> path = new ArrayList<>();
                dfs(idx, path);
            }
        }
        return result;
    }

    // Depth-First Search (DFS) to detect cycles
    private void dfs(int idx, List<Integer> path) {
        visited[idx] = true;
        indexMap.put(idx, path.size());
        path.add(idx);

        for (int issue = 0; issue < issues[idx].length; issue++) {
            if (issues[idx][issue] == 0) { // No dependency
                continue;
            }
            if (visited[issue]) { // Cycle detected
                addCycle(indexMap.get(issue), path.size() - 1, path);
            } else {
                dfs(issue, path);
            }
        }

        // Backtrack
        path.remove(path.size() - 1);
        indexMap.remove(idx);
    }

    // Extracts and stores a cycle from the DFS path
    private void addCycle(int start, int end, List<Integer> path) {
        List<Integer> cycle = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            cycle.add(path.get(i));
        }
        result.add(cycle);
    }

    public static void main(String[] args) {
        // Example usage
        int[][] issues = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0}
        };

        Google checker = new Google(issues);
        List<List<Integer>> cycles = checker.findCycles();
        System.out.println("Detected Cycles: " + cycles);
    }
}

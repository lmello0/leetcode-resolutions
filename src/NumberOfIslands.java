import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Set<String> visited = new HashSet<>();

        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String position = i + "," + j;

                if (grid[i][j] == '1' && !visited.contains(position)) {
                    dfs(visited, i, j, rows, cols, grid);

                    islands++;
                }
            }
        }

        return islands;
    }

    private static void dfs(Set<String> visited, int row, int col, int rowLength, int colLength, char[][] grid) {
        String position = row + "," + col;
        if (visited.contains(position) || row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] == '0') {
            return;
        }

        visited.add(position);
        dfs(visited, row+1, col, rowLength, colLength, grid);
        dfs(visited, row-1, col, rowLength, colLength, grid);
        dfs(visited, row, col+1, rowLength, colLength, grid);
        dfs(visited, row, col-1, rowLength, colLength, grid);
    }
}

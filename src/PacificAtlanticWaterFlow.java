import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        Set<int[]> pacific = new HashSet<>();
        Set<int[]> atlantic = new HashSet<>();

        int ROWS = heights.length;
        int COLUMNS = heights[0].length;

        for (int c = 0; c < COLUMNS; c++) {
            dfs(heights, 0, c, heights[0][c], pacific, ROWS, COLUMNS);
            dfs(heights, ROWS - 1, c, heights[ROWS - 1][c], atlantic, ROWS, COLUMNS);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, heights[r][0], pacific, ROWS, COLUMNS);
            dfs(heights, r, COLUMNS - 1, heights[r][COLUMNS - 1], atlantic, ROWS, COLUMNS);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                int[] position = new int[]{r, c};
                if (pacific.contains(position) && atlantic.contains(position)) {
                    res.add(List.of(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int row, int column, int prevHeight, Set<int[]> visit, int maxRows, int maxColumns) {
        if (visit.contains(new int[]{row, column}) || row < 0 || column < 0 || row == maxRows || column == maxColumns || heights[row][column] < prevHeight) {
            return;
        }

        visit.add(new int[]{row, column});

        dfs(heights, row + 1, column, heights[row][column], visit, maxRows, maxColumns);
        dfs(heights, row - 1, column, heights[row][column], visit, maxRows, maxColumns);
        dfs(heights, row, column + 1, heights[row][column], visit, maxRows, maxColumns);
        dfs(heights, row, column - 1, heights[row][column], visit, maxRows, maxColumns);
    }


    public static void main(String[] args) {
        int[][] heights = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

        PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
        System.out.println(pawf.pacificAtlantic(heights));
    }
}

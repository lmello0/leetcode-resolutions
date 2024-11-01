import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char cell = board[row][column];

                if (cell == '.') {
                    continue;
                }

                if (rows.getOrDefault(row, new HashSet<>()).contains(cell)) {
                    return false;
                }

                if (cols.getOrDefault(column, new HashSet<>()).contains(cell)) {
                    return false;
                }

                int squareKey = (row / 3) * 3 + column / 3;
                if (squares.getOrDefault(squareKey, new HashSet<>()).contains(cell)) {
                    return false;
                }

                cols.computeIfAbsent(column, k -> new HashSet<>()).add(cell);
                rows.computeIfAbsent(row, k -> new HashSet<>()).add(cell);
                squares.computeIfAbsent(squareKey, k -> new HashSet<>()).add(cell);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println(isValidSudoku(board));
    }
}

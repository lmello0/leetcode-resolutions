import java.util.HashSet;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char cell = board[row][column];

                if (cell == '.') {
                    continue;
                }

                 int squareIndex = (row / 3) * 3 + (column / 3);

                if (rows[row].contains(cell) || cols[column].contains(cell) || squares[squareIndex].contains(cell)) {
                    return false;
                }

                rows[row].add(cell);
                cols[column].add(cell);
                squares[squareIndex].add(cell);
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

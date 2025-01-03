public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length - 1;

        int seekRow = 0;
        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == target || matrix[i][colLength] == target) {
                return true;
            }

            if (matrix[i][0] < target && matrix[i][colLength] > target) {
                seekRow = i;
                break;
            }
        }

        int left = 0;
        int right = colLength;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (matrix[seekRow][middle] == target) {
                return true;
            } else if (matrix[seekRow][middle] < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}};

        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 3));
        System.out.println(new SearchA2DMatrix().searchMatrix(matrix, 13));

        String text = null;
        System.out.println(text.length());
    }
}

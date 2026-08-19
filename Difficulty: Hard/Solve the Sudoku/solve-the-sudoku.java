class Solution {
    public void solveSudoku(int[][] mat) {
        solve(mat);
    }

    public boolean solve(int[][] mat) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (mat[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(mat, row, col, num)) {
                            mat[row][col] = num;

                            if (solve(mat))
                                return true;

                            mat[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(int[][] mat, int row, int col, int num) {
        for (int j = 0; j < 9; j++) {
            if (mat[row][j] == num)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (mat[i][col] == num)
                return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (mat[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}
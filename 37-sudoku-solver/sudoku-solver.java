class Solution{
public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve (char[][] board) {
        for (int i = 0; i < 9; i++) 
            for (int j = 0; j < 9; j++) 
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++)   
                        if (val(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board))
                                return true;
                            board[i][j] = '.';
                        }  
                    return false;
                }
        return true;
    }

    public boolean val(char[][] board, int i, int j, char k) {
        for (int l = 0; l < 9; l++)
            if (board[i][l] == k)
                return false;
        for (int l = 0; l < 9; l++)
            if (board[l][j] == k)
                return false;
        int r3 = (i / 3) * 3;
        int c3 = (j / 3) * 3;
        for (int l = r3; l < r3 + 3; l++)
            for (int m = c3; m < c3 + 3; m++)
                if (board[l][m] == k)
                    return false;

        return true;    
    }
}
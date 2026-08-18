class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length; 
       for(int i = 0 ; i < n ; i++){
         for(int j = 0 ; j < m ; j++){
          if(found(board,word,i,j,0,n,m)){
            return true;
          }
        }
       }
       return false;
    }
    public boolean found(char[][] board , String word,int i , int j , int idx,int n , int m){
        if(idx == word.length())
           return true;
        if(i < 0 || j < 0 || i >= n || j >= m || board[i][j] != word.charAt(idx))
          return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean Found = found(board, word, i + 1, j, idx + 1,n,m) ||
                        found(board, word, i - 1, j, idx + 1,n,m) ||
                        found(board, word, i, j + 1, idx + 1,n,m) ||
                        found(board, word, i, j - 1, idx + 1,n,m);
       board[i][j] = temp;
       return Found;
    }
}
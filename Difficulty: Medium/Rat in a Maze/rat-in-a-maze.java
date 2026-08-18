class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> list = new ArrayList<>();
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
            return list;

        StringBuilder str = new StringBuilder();

        check(maze, list, str, 0, 0, visited);

        return list;
    }

    public void check(int[][] maze, ArrayList<String> list,
                      StringBuilder str, int row, int col,
                      boolean[][] visited) {

        int n = maze.length;

        if (row == n - 1 && col == n - 1) {
            list.add(str.toString());
            return;
        }

        visited[row][col] = true;

        if (row + 1 < n && maze[row + 1][col] == 1
                && !visited[row + 1][col]) {
            str.append('D');
            check(maze, list, str, row + 1, col, visited);
            str.deleteCharAt(str.length() - 1);
        }

        if (col - 1 >= 0 && maze[row][col - 1] == 1
                && !visited[row][col - 1]) {
            str.append('L');
            check(maze, list, str, row, col - 1, visited);
            str.deleteCharAt(str.length() - 1);
        }

        if (col + 1 < n && maze[row][col + 1] == 1
                && !visited[row][col + 1]) {
            str.append('R');
            check(maze, list, str, row, col + 1, visited);
            str.deleteCharAt(str.length() - 1);
        }

        if (row - 1 >= 0 && maze[row - 1][col] == 1
                && !visited[row - 1][col]) {
            str.append('U');
            check(maze, list, str, row - 1, col, visited);
            str.deleteCharAt(str.length() - 1);
        }

        visited[row][col] = false;
    }
}
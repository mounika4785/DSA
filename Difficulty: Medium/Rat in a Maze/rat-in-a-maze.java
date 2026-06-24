import java.util.*;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        
        // If start or destination is blocked, no paths exist
        if (maze[0][0] == 0 || maze[n-1][n-1] == 0) return result;
        
        dfs(0, 0, maze, visited, n, "", result);
        Collections.sort(result); // ensure lexicographic order
        return result;
    }
    
    private void dfs(int i, int j, int[][] maze, boolean[][] visited, int n, String path, ArrayList<String> result) {
        // Destination reached
        if (i == n-1 && j == n-1) {
            result.add(path);
            return;
        }
        
        visited[i][j] = true;
        
        // Explore in lexicographic order: D, L, R, U
        // Down
        if (i+1 < n && maze[i+1][j] == 1 && !visited[i+1][j]) {
            dfs(i+1, j, maze, visited, n, path + "D", result);
        }
        // Left
        if (j-1 >= 0 && maze[i][j-1] == 1 && !visited[i][j-1]) {
            dfs(i, j-1, maze, visited, n, path + "L", result);
        }
        // Right
        if (j+1 < n && maze[i][j+1] == 1 && !visited[i][j+1]) {
            dfs(i, j+1, maze, visited, n, path + "R", result);
        }
        // Up
        if (i-1 >= 0 && maze[i-1][j] == 1 && !visited[i-1][j]) {
            dfs(i-1, j, maze, visited, n, path + "U", result);
        }
        
        visited[i][j] = false; // backtrack
    }
}

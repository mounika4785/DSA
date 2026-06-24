import java.util.*;

class Solution {
    public boolean graphColoring(int V, int[][] edges, int m) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] colors = new int[V]; 
        return solve(0, adj, colors, m, V);
    }

    private boolean solve(int node, List<List<Integer>> adj, int[] colors, int m, int V) {
        if (node == V) return true; 
        for (int c = 1; c <= m; c++) {
            if (isSafe(node, adj, colors, c)) {
                colors[node] = c;
                if (solve(node + 1, adj, colors, m, V)) return true;
                colors[node] = 0; 
            }
        }
        return false;
    }

    private boolean isSafe(int node, List<List<Integer>> adj, int[] colors, int color) {
        for (int neighbor : adj.get(node)) {
            if (colors[neighbor] == color) return false;
        }
        return true;
    }
}

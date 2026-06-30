import java.util.*;
class Solution {
    static class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
        public ArrayList<Integer> mergeArrays(int[][] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        ArrayList<Integer> ans = new ArrayList<>();
        int k = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < k; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
        }
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            ans.add(curr.value);

            if (curr.col + 1 < m) {
                pq.offer(new Node(arr[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }

        return ans;
    }
}
        

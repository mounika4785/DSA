import java.util.*;

class Solution {

    static class Node {
        int sum;
        int i;
        int j;

        Node(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {

        int n = a.length;

        Arrays.sort(a);
        Arrays.sort(b);

        reverse(a);
        reverse(b);

        PriorityQueue<Node> maxHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node x, Node y) {
                return y.sum - x.sum;
            }
        });

        HashSet<String> visited = new HashSet<>();

        ArrayList<Integer> ans = new ArrayList<>();

        maxHeap.offer(new Node(a[0] + b[0], 0, 0));
        visited.add("0#0");

        while (k > 0 && !maxHeap.isEmpty()) {

            Node curr = maxHeap.poll();
            ans.add(curr.sum);

            int i = curr.i;
            int j = curr.j;

            // (i + 1, j)
            if (i + 1 < n) {
                String key = (i + 1) + "#" + j;

                if (!visited.contains(key)) {
                    maxHeap.offer(new Node(a[i + 1] + b[j], i + 1, j));
                    visited.add(key);
                }
            }

            if (j + 1 < n) {
                String key = i + "#" + (j + 1);

                if (!visited.contains(key)) {
                    maxHeap.offer(new Node(a[i] + b[j + 1], i, j + 1));
                    visited.add(key);
                }
            }

            k--;
        }

        return ans;
    }

    static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
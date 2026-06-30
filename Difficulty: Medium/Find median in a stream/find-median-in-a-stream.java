import java.util.*;
class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        ArrayList<Double> ans = new ArrayList<>();

        for (int num : arr) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() == minHeap.size()) {
                ans.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            } else {
                ans.add((double) maxHeap.peek());
            }
        }

        return ans;
    }
}
        
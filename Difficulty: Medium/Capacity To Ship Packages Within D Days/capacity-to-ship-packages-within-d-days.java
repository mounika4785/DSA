class Solution {

    int requiredDays(ArrayList<Integer> arr, int capacity) {
        int days = 1;
        int load = 0;

        for (int weight : arr) {
            if (load + weight > capacity) {
                days++;
                load = weight;
            } else {
                load += weight;
            }
        }

        return days;
    }

    public int leastWeightCapacity(ArrayList<Integer> arr, int D) {

        int low = 0;
        int high = 0;

        for (int weight : arr) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (requiredDays(arr, mid) <= D) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
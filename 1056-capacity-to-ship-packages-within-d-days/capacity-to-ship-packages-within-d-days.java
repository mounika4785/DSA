class Solution {

    public int cap(int[] weights, int val) {
        int capacity = 0;
        int days = 1;

        for (int num : weights) {
            if (capacity + num > val) {
                days++;
                capacity = num;
            } else {
                capacity += num;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int num : weights) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int needDays = cap(weights, mid);

            if (needDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
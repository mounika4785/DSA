class Solution {

    int bouquets(int[] arr, int day, int k) {
        int flowers = 0;
        int count = 0;

        for (int bloom : arr) {
            if (bloom <= day) {
                flowers++;
            } else {
                count += flowers / k;
                flowers = 0;
            }
        }

        count += flowers / k;
        return count;
    }

    public int minDaysBloom(int[] arr, int k, int m) {

        if ((long) k * m > arr.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int bloom : arr) {
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (bouquets(arr, mid, k) >= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
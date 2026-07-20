class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length)
            return -1;

        int low = 1;
        int high = 0;

        for (int bloom : bloomDay) {
            high = Math.max(high, bloom);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int bo = blooming(bloomDay, mid, k);

            if (bo >= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int blooming(int[] bloomDay, int days, int k) {
        int flowers = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= days) {
                flowers++;
            } else {
                bouquets += flowers / k;
                flowers = 0;
            }
        }

        bouquets += flowers / k;

        return bouquets;
    }
}
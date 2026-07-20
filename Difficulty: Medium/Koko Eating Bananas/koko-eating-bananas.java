class Solution {
    public int hours(int[] arr, int speed) {
        int total = 0;

        for (int bananas : arr) {
            total += (bananas + speed - 1) / speed;
        }

        return total;
    }

    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = 0;

        for (int bananas : arr) {
            high = Math.max(high, bananas);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (hours(arr, mid) <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
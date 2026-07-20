class Solution {

    int findSum(int[] arr, int divisor) {
        int sum = 0;

        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;
        }

        return sum;
    }

    int smallestDivisor(int[] arr, int k) {

        int low = 1;
        int high = 0;

        for (int num : arr) {
            high = Math.max(high, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (findSum(arr, mid) <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
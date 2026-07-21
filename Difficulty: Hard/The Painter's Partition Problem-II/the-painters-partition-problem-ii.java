class Solution {

    public int countPainters(int[] arr, int maxTime) {
        int painters = 1;
        int time = 0;

        for (int board : arr) {
            if (time + board <= maxTime) {
                time += board;
            } else {
                painters++;
                time = board;
            }
        }

        return painters;
    }

    public int minTime(int[] arr, int k) {
        int n = arr.length;

        if (k > n) return -1;

        int low = 0;
        int high = 0;

        for (int board : arr) {
            low = Math.max(low, board);
            high += board;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int painters = countPainters(arr, mid);

            if (painters <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
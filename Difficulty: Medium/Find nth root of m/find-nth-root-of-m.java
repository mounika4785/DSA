class Solution {
    public int nthRoot(int n, int m) {
        if (m == 0) return 0;
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            long ans = 1;
            for (int i = 1; i <= n; i++) {
                ans *= mid;
                if (ans > m) break;
            }
            if (ans == m) {
                return mid;
            } else if (ans < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

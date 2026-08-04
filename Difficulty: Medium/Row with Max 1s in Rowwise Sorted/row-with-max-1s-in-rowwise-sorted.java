class Solution {

    public int lowerOne(int[][] arr, int row, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[row][mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int index = -1;
        int cntMax = 0;

        for (int i = 0; i < n; i++) {

            int firstOne = lowerOne(arr, i, m, 1);

            int cntOnes = m - firstOne;

            if (cntMax < cntOnes) {
                cntMax = cntOnes;
                index = i;
            }
        }

        return index;
    }
}
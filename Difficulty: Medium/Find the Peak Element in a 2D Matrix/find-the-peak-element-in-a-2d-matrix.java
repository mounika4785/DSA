class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRow = 0;

            for (int i = 1; i < n; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int current = mat[maxRow][mid];

            int left = (mid == 0) ? Integer.MIN_VALUE : mat[maxRow][mid - 1];
            int right = (mid == m - 1) ? Integer.MIN_VALUE : mat[maxRow][mid + 1];

            if (current >= left && current >= right) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(maxRow);
                ans.add(mid);
                return ans;
            }

            if (left > current) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new ArrayList<>();
    }
}
class Solution {
    public boolean searchMatrix(int[][] arr, int x) {
        
        int n = arr.length;
        int m = arr[0].length;

        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = mid / m;
            int col = mid % m;

            if (arr[row][col] == x) {
                return true;
            }
            else if (arr[row][col] < x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}
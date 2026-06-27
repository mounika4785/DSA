class Solution {
    private boolean isPossible(int[] arr, int k, int mid) {
        int studentCount = 1; 
        int pages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) return false;

            if (pages + arr[i] > mid) {
                studentCount++;   
                pages = arr[i];   
                if (studentCount > k) return false; 
            } else {
                pages += arr[i];
            }
        }
        return true;
    }
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1; 

        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < n; i++) {
            high += arr[i];
            low = Math.max(low, arr[i]); 
        }
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, k, mid)) {
                result = mid;      
                high = mid - 1;
            } else {
                low = mid + 1;     
            }
        }
        return result;
    }
}

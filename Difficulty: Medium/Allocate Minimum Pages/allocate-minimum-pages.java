class Solution {

    public int countStudents(int[] arr, long maxPages) {
        int students = 1;
        long pages = 0;

        for (int num : arr) {
            if (pages + num <= maxPages) {
                pages += num;
            } else {
                students++;
                pages = num;
            }
        }

        return students;
    }

    public int findPages(int[] arr, long k) {
        int n = arr.length;

        if (k > n) return -1;

        long low = arr[0];
        long high = 0;

        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long students = countStudents(arr, mid);

            if (students <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int)low;
    }
}
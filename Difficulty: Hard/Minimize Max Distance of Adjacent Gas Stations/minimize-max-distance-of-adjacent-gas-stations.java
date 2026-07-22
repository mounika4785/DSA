class Solution {
   
    public static int requiredStations(int[] arr, double dist) {
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            double gap = arr[i] - arr[i - 1];
            count += (int)(gap / dist);

            if (gap == dist * (int)(gap / dist)) {
                count--;
            }
        }

        return count;
    }

       public double minMaxDist(int[] arr, int k) {

        double low = 0;
        double high = 0;

        for (int i = 1; i < arr.length; i++) {
            high = Math.max(high, arr[i] - arr[i - 1]);
        }

        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;

            if (requiredStations(arr, mid) > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }
}
        

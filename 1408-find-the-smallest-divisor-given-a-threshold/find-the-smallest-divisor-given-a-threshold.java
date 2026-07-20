class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int div = divisor(nums, mid);

            if (div <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    public int divisor(int nums[] , int val){
        int result = 0;
        for(int num : nums)
        result += (num + val - 1) / val;
        return result;
    }
}
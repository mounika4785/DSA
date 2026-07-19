class Solution {
    public int findKRotation(int nums[]) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        int res = 0;
        while (low <= high) {
            if (nums[low] <= nums[high]) {
               if(nums[low] < ans){
                    ans = nums[low];
                    res = low;
                }
                break;
            }
            int mid = low + (high - low) / 2;
            if (nums[low] <= nums[mid]) {
                if(nums[low] < ans){
                    ans = nums[low];
                    res = low;
                }
                low = mid + 1;
            }
            else {
               if(nums[mid] < ans){
                    ans = nums[mid];
                    res = mid;
                }
                high = mid - 1;
            }
        }

        return res;
    }
}

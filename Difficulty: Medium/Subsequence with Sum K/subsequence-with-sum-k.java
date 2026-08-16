class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
       return func(0,k,arr);
    }
    private boolean func(int ind, int sum, int[] nums) {
        if (sum == 0) return true;
        if (sum < 0 || ind == nums.length) return false;
        return func(ind + 1, sum - nums[ind], nums) ||
        func(ind + 1, sum, nums);
        
    }
}
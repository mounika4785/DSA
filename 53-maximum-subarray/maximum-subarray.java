class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max1 = Integer.MIN_VALUE;
    for(int i = 0 ; i < nums.length;i++){
      sum = Math.max( sum + nums[i] , nums[i]);
      max1 = Math.max(max1,sum);
    }
    return max1;
}
}
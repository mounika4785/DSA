class Solution {
    public int[] singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            ans ^= nums[i];
        }
        int bit = ans & -ans;
        int a = 0;
        int b = 0;
        for(int num : nums){
            if((bit&num)!=0)
              a ^= num;
            else 
             b ^= num;
        }
        return new int[] {a,b};
    }
}
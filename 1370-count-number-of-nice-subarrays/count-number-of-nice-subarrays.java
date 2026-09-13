class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return counting(nums,k) - counting(nums,k-1);
    }
    public int counting(int[] nums  , int k){
        int count = 0;
         int left = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 == 1){
              k--;
            }
            while(k < 0){
                if(nums[left]%2 != 0)
                   k++;
                left++;
            }

           count += (i-left+1);  
        }
        return count;
    }
}
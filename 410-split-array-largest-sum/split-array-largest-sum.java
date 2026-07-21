class Solution {
    public int array(int arr[] , int val){
        int sum = 0;
        int count = 1;
        for(int num : arr)
        {
            if(sum + num <= val){
                sum += num;
            }
            else{
                count++;
                sum = num;
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int n = nums.length;
        for(int num : nums){
            low = Math.max(low,num);
            high += num;
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            int check = array(nums,mid);
            if(check <= k){
                high = mid - 1;
            }
            else 
               low = mid + 1;
         }
    return low;
}
}
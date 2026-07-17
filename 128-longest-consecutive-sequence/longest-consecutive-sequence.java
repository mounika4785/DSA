import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int val = 1;   
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue; 
            }
            if (nums[i] == nums[i - 1] + 1) {
                count++; 
            } else {
                count = 1;
            }
            val = Math.max(val, count);
        }
        return val;
    }
}

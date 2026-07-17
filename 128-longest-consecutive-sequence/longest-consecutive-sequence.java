import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer>set = new HashSet<>();
        for(int num : nums){
          set.add(num);
        }
        int max = 1;
        for(int num : set){
            if(!set.contains(num-1)){
               int cnt = 1;
               while(set.contains(num+1)){
                cnt++;
                num = num+1;
               }
               max = Math.max(max,cnt);
            }
        } 
      return max; 
    }
}

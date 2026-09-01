import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                ans[st.pop()] = nums[i];
            }
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                ans[st.pop()] = nums[i];
            }
        }

        return ans;
    }
}
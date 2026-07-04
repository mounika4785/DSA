class Solution {
    public static int[] help_classmate(int arr[], int n) {

        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                ans[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        return ans;
    }
}
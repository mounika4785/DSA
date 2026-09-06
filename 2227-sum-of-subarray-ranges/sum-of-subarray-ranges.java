class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public int[] nse(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();

            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    public int[] pse(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();

            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    public long sumSubarrayMins(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int[] ps = pse(arr);
        int[] ns = nse(arr);

        for (int i = 0; i < n; i++) {
            int left = i - ps[i];
            int right = ns[i] - i;
            long freq = left * right * 1L;
            long val = freq * arr[i];
            sum = sum + val;
        }
        return sum;
    }

    public int[] nge(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();

            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    public int[] pge(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i])
                st.pop();

            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    public long sumSubarrayMaxs(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int[] pg = pge(arr);
        int[] ng = nge(arr);

        for (int i = 0; i < n; i++) {
            int left = i - pg[i];
            int right = ng[i] - i;
            long freq = left * right * 1L;
            long val = freq * arr[i];
            sum = sum + val;
        }
        return sum;
    }
}
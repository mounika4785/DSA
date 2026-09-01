class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
       int n = arr.length;
       ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
       Stack<Integer> stc = new Stack<>();

       for (int i = n - 1; i >= 0; i--) {
           while (!stc.isEmpty() && stc.peek() >= arr[i]) {
               stc.pop();
           }

           if (!stc.isEmpty()) {
               ans.set(i, stc.peek());
           }

           stc.push(arr[i]);
       }

       return ans;
    }
}
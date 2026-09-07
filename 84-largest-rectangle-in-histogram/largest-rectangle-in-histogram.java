class Solution {
    public int largestRectangleArea(int[] heights) {
       int  n = heights.length;
       int left[] = new int[n]; 
       int right[] = new int[n];
       Stack<Integer>st = new Stack<>();
       for(int i = 0 ; i < n ; i++){
          while(!st.isEmpty() && heights[st.peek()] >= heights[i])
           st.pop();
          left[i] = st.isEmpty() ? 0 : st.peek()+1;
          st.push(i);
       }
       st.clear();
       for(int i = n-1 ; i >= 0 ; i--){
          while(!st.isEmpty() && heights[st.peek()] >= heights[i])
           st.pop();
          right[i] = st.isEmpty() ? n-1 : st.peek()-1;
          st.push(i);
       }
       int max = 0;
       for(int i = 0 ; i < n ; i++){
        int width = right[i]-left[i]+1;
        max = Math.max(max,heights[i]*width);
       }
  return max;
    }
}
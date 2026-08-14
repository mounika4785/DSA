class Solution {
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty())
          return;
        int top = st.pop();
        reverseStack(st);
        insert(st,top);
        
    }
    public static void insert(Stack<Integer> st , int val) {
        if(st.isEmpty()){
            st.push(val);
            return;
        }
        int top = st.pop();
        insert(st,val);
        st.push(top);
    }
    
}

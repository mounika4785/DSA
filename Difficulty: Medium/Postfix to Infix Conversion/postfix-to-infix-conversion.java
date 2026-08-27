import java.util.*;

class Solution {

    static String postToInfix(String s) {

        Stack<String> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String first = st.pop();
                String second = st.pop();

                String result = "(" + second + ch + first + ")";

                st.push(result);
            }
        }

        return st.pop();
    }
}
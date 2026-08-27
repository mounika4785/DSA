import java.util.*;

class Solution {

    static String preToPost(String s) {

        Stack<String> st = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String first = st.pop();
                String second = st.pop();

                String result = first + second + ch;

                st.push(result);
            }
        }

        return st.pop();
    }
}
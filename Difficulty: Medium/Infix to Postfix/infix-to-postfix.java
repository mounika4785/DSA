class Solution {
    public static String infixToPostfix(String s) {
     Stack<Character> st = new Stack<>();
     StringBuilder ans = new StringBuilder();
    
     for (int i = 0; i < s.length(); i++) {
    
         char ch = s.charAt(i);
    
         if (Character.isLetterOrDigit(ch)) {
             ans.append(ch);
         }
    
         else if (ch == '(') {
             st.push(ch);
         }
    
         else if (ch == ')') {
    
             while (!st.isEmpty() && st.peek() != '(') {
                 ans.append(st.pop());
             }
    
             st.pop(); 
         }
    
         else {

             while (!st.isEmpty() &&
                    st.peek() != '(' &&
                    (precedence(st.peek()) > precedence(ch) ||
                    (precedence(st.peek()) == precedence(ch) && ch != '^'))) {

                 ans.append(st.pop());
             }

             st.push(ch);
         }
     }
    
     while (!st.isEmpty()) {
         ans.append(st.pop());
     }
    
     return ans.toString();
    }
    
    static int precedence(char ch) {
    
     if (ch == '^')
         return 3;
    
     if (ch == '*' || ch == '/' || ch == '%')
         return 2;
    
     if (ch == '+' || ch == '-')
         return 1;
    
     return 0;
    }
        
    }

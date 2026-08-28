class Solution {
    public String removeKdig(String s, int k) {
   
           Deque<Character> stack = new ArrayDeque<>();
           for (char digit : s.toCharArray()) {
               while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                   stack.pollLast();
                   k--;
               }
               stack.addLast(digit);
           }
           while (k > 0 && !stack.isEmpty()) {
               stack.pollLast();
               k--;
           }
           StringBuilder sb = new StringBuilder();
           for (char digit : stack) sb.append(digit);
           while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
           return sb.length() == 0 ? "0" : sb.toString();
       

    }
}
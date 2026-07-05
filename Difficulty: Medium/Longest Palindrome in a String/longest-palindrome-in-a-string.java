class Solution {
    static int start, maxLen;

    static String longestPalindrome(String s) {
        start = 0;
        maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }

        return s.substring(start, start + maxLen);
    }

    static void expand(String s, int left, int right) {
        if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right))
            return;

        if (right - left + 1 > maxLen) {
            maxLen = right - left + 1;
            start = left;
        }

        expand(s, left - 1, right + 1);
    }
}
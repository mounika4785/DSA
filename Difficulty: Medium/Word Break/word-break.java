class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        Boolean[] dp = new Boolean[s.length() + 1];
        return form(s, dictionary, 0, dp);
    }

    public boolean form(String s, String[] dictionary,
                        int start, Boolean[] dp) {

        if (start == s.length())
            return true;

        if (dp[start] != null)
            return dp[start];

        for (String word : dictionary) {

            if (start + word.length() <= s.length() &&
                s.substring(start, start + word.length()).equals(word)) {

                if (form(s, dictionary,
                         start + word.length(), dp)) {
                    return dp[start] = true;
                }
            }
        }

        return dp[start] = false;
    }
}
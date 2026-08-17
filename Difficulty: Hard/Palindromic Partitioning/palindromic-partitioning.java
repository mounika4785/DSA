class Solution {
    public int palPartition(String s) {
        int n = s.length();

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        return cost(s, n, 0, dp) - 1;
    }

    public int cost(String s, int n, int i, int[] dp) {

        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {

            if (palindrome(s, i, j)) {

                int cost = 1 + cost(s, n, j + 1, dp);

                minCost = Math.min(minCost, cost);
            }
        }

        return dp[i] = minCost;
    }

    public boolean palindrome(String s, int i, int j) {

        while (i <= j) {

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
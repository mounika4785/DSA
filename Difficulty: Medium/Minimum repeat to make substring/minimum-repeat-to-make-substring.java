class Solution {
    static final int BASE = 256;
    static final int MOD = 1000000007;

    public int minRepeats(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1);
        int count = 1;

        while (sb.length() < s2.length()) {
            sb.append(s1);
            count++;
        }

        if (rabinKarp(sb.toString(), s2))
            return count;

        sb.append(s1);
        count++;

        if (rabinKarp(sb.toString(), s2))
            return count;

        return -1;
    }

    private boolean rabinKarp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m > n)
            return false;

        long patHash = 0;
        long txtHash = 0;
        long power = 1;

        for (int i = 0; i < m - 1; i++)
            power = (power * BASE) % MOD;

        for (int i = 0; i < m; i++) {
            patHash = (patHash * BASE + pattern.charAt(i)) % MOD;
            txtHash = (txtHash * BASE + text.charAt(i)) % MOD;
        }

        for (int i = 0; i <= n - m; i++) {

            if (patHash == txtHash) {
                if (text.substring(i, i + m).equals(pattern))
                    return true;
            }

            if (i < n - m) {
                txtHash = (txtHash - text.charAt(i) * power % MOD + MOD) % MOD;
                txtHash = (txtHash * BASE + text.charAt(i + m)) % MOD;
            }
        }

        return false;
    }
}
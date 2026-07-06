class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        int count = 1;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        int extra = 0;
        while (extra <= 1) {
            if (sub(sb.length(), sb, b)) {
                return count;
            } else {
                sb.append(a);
                count++;
                extra++;
            }
        }

        return -1;
    }

    public boolean sub(int n, StringBuilder s, String b) {
        int m = b.length();

        for (int i = 0; i <= n - m; i++) {
            if (s.substring(i, i + m).equals(b)) {
                return true;
            }
        }

        return false;
    }
}
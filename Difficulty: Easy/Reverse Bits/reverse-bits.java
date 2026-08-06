class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        while (n > 0) {
            ans = ans * 2 + (n % 2);
            n = n / 2;
        }

        return ans;
    }
}
        
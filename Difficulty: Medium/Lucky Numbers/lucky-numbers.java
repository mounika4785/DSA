class Solution {
    public boolean isLucky(int n) {
        return check(n, 2);
    }

    private boolean check(int n, int counter) {
        if (counter > n) {
            return true;
        }

        if (n % counter == 0) {
            return false;
        }

        n = n - (n / counter);

        return check(n, counter + 1);
    }
}
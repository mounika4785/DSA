import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        solve(num, target, 0, 0, 0, "", ans);
        return ans;
    }

    public void solve(String num, int target, int index,
                      long value, long previous,
                      String exp, List<String> ans) {

        if (index == num.length()) {
            if (value == target)
                ans.add(exp);
            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i > index && num.charAt(index) == '0')
                break;

            String part = num.substring(index, i + 1);
            long current = Long.parseLong(part);

            if (index == 0) {
                solve(num, target, i + 1,
                      current, current,
                      part, ans);
            } else {

                solve(num, target, i + 1,
                      value + current, current,
                      exp + "+" + part, ans);

                solve(num, target, i + 1,
                      value - current, -current,
                      exp + "-" + part, ans);

                long newValue = value - previous + previous * current;

                solve(num, target, i + 1,
                      newValue, previous * current,
                      exp + "*" + part, ans);
            }
        }
    }
}
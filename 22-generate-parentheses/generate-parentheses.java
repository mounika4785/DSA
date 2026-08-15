class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        generate(n, "", 0, 0, arr);
        return arr;
    }
    public void generate(int n, String s, int open, int close,
                         List<String> list) {

        if (s.length() == 2 * n) {
            list.add(s);
            return;
        }
        if (open < n) {
            generate(n, s + "(", open + 1, close, list);
        }
        if (close < open) {
            generate(n, s + ")", open, close + 1, list);
        }
    }
}
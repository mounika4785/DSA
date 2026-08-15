class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        generate(n, "", arr);
        return arr;
    }

    public void generate(int n, String s, List<String> list) {
        if (s.length() == 2 * n) {

            if (checkParenthesis(s)) {
                list.add(s);
            }

            return;
        }

        generate(n, s + "(", list);
        generate(n, s + ")", list);
    }

    public boolean checkParenthesis(String s) {
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(')
                balance++;
            else
                balance--;

            if (balance < 0)
                return false;
        }

        return balance == 0;
    }
}
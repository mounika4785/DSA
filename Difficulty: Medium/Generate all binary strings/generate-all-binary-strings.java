class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> arr = new ArrayList<>();
        generate(n, "", arr);
        return arr;
    }

    public void generate(int n, String s, ArrayList<String> list) {
        if (s.length() == n) {
            list.add(s);
            return;
        }

        generate(n, s + "0", list);
        generate(n, s + "1", list);
    }
}
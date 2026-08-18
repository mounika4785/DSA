 class Solution {
        public ArrayList<ArrayList<Integer>> nQueen(int n) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();

            check(n, 0, res, list);

            return list;
        }

        public void check(int n, int row, ArrayList<Integer> res,
                          ArrayList<ArrayList<Integer>> list) {

            if (row == n) {
                list.add(new ArrayList<>(res));
                return;
            }

            for (int col = 0; col < n; col++) {

                if (isSafe(row, col, res)) {

                    res.add(col + 1);

                    check(n, row + 1, res, list);

                    res.remove(res.size() - 1);
                }
            }
        }

        public boolean isSafe(int row, int col, ArrayList<Integer> res) {

            for (int r = 0; r < row; r++) {

                int c = res.get(r) - 1;

                if (c == col) {
                    return false;
                }

                if (Math.abs(r - row) == Math.abs(c - col)) {
                    return false;
                }
            }

            return true;
        }
    }
    

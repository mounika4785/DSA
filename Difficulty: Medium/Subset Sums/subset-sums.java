class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        sum(arr, 0, list, 0);

        return list;
    }

    public void sum(int[] arr, int index, ArrayList<Integer> list, int sum) {

        if (index == arr.length) {
            list.add(sum);
            return;
        }

        sum(arr, index + 1, list, sum + arr[index]);
        sum(arr, index + 1, list, sum);
    }
}
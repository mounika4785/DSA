class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        sum(nums, 0, list, res);
        return list;
    }

    public void sum(int[] arr, int index,
                    List<List<Integer>> list,
                    List<Integer> res) {

        if (index == arr.length) {
            if (!list.contains(res)) {
                list.add(new ArrayList<>(res));
            }
            return;
        }

        res.add(arr[index]);
        sum(arr, index + 1, list, res);
        res.remove(res.size() - 1);
        sum(arr, index + 1, list, res);
    }
}
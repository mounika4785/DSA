class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        sum(candidates, target, list, res, 0, 0);

        return list;
    }

    public void sum(int[] arr, int target, List<List<Integer>> list,
                    List<Integer> res, int index, int sum) {

        if (sum == target) {
            list.add(new ArrayList<>(res));
            return;
        }

        if (index == arr.length || sum > target) {
            return;
        }

      
        res.add(arr[index]);
        sum(arr, target, list, res, index, sum + arr[index]);
   
   
        res.remove(res.size() - 1);

        int next = index + 1;

        while (next < arr.length && arr[next] == arr[index]) {
            next++;
        }
        sum(arr, target, list, res, next, sum);
    }
}
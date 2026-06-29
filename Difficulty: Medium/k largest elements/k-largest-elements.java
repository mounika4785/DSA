import java.util.*;
class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
    ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, Collections.reverseOrder());
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && i < list.size(); i++) {
            result.add(list.get(i));
        }
        return result;
    }
}

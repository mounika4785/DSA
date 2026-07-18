class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int xr = 0;
        long cnt = 0;

        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            xr ^= arr[i];

            int x = xr ^ k;

            cnt += map.getOrDefault(x, 0);

            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return cnt;
    }
}